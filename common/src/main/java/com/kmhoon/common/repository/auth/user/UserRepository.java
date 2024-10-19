package com.kmhoon.common.repository.auth.user;

import com.kmhoon.common.model.entity.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u " +
            "from User u " +
            "join fetch u.userRoleList url " +
            "join fetch url.role " +
            "where u.email = :email")
    Optional<User> findByEmailWithRoles(@Param("email") String email);

    Optional<User> findByEmail(String email);
}
