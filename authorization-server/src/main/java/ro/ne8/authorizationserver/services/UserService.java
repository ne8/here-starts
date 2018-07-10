package ro.ne8.authorizationserver.services;


import ro.ne8.authorizationserver.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(UserEntity userEntity);

    List<UserEntity> findAll();

    UserEntity getByEmail(String email);

    Optional<UserEntity> getById(Long id);

    void delete(UserEntity userEntity);

    UserEntity findByUsername(String nickname);

    boolean isUserAlreadyRegistered(UserEntity userEntity);
}
