package ro.ne8.authorizationserver.facades;



import ro.ne8.authorizationserver.dto.UserDTO;

import java.util.List;

public interface UserFacade {
    void save(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO getByEmail(String email);

    UserDTO getById(Long id);

    void delete(UserDTO userDTO);
}
