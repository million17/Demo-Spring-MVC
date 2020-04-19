package application.repository;

import application.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {

    @Query("select u from " +
            "user_role u" +
            " where u.userId=:id")
    Iterable<UserRoleEntity> findRolesOfUser(@Param("id") int userId);
}
