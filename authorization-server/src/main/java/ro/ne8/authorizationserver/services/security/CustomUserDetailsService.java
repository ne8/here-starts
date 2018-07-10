package ro.ne8.authorizationserver.services.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ne8.authorizationserver.entities.UserEntity;
import ro.ne8.authorizationserver.entities.UserRoleEntity;
import ro.ne8.authorizationserver.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private static final String STATE_ACTIVE = "Active";
    private static final String ROLE_PREFIX_REQUIRED_BY_SPRING_SECURITY_CONTEXT = "ROLE_";

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String nickname) throws UsernameNotFoundException {
        CustomUserDetailsService.LOGGER.debug("trying to fetch user with nickname:" + nickname);
        final UserEntity userEntity = this.userService.findByUsername(nickname);
        if (userEntity == null) {
            CustomUserDetailsService.LOGGER.error("user not found");
            throw new UsernameNotFoundException("User not found");
        }
        final User springSecurityUser = new User(userEntity.getUsername(), userEntity.getPassword(),
                userEntity.getState().equals(CustomUserDetailsService.STATE_ACTIVE), userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(), userEntity.isAccountNonLocked(), this.getGrantedAuthorities(userEntity));
        return springSecurityUser;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final UserEntity userEntity) {
        final List<GrantedAuthority> authorities = new ArrayList<>();

        for (final UserRoleEntity userRoleType : userEntity.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(CustomUserDetailsService.ROLE_PREFIX_REQUIRED_BY_SPRING_SECURITY_CONTEXT + userRoleType.getType()));
        }
        return authorities;
    }
}
