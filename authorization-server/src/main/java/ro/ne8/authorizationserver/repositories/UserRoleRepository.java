package ro.ne8.authorizationserver.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ne8.authorizationserver.entities.UserRoleEntity;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {
    UserRoleEntity findByType(String type);
}
