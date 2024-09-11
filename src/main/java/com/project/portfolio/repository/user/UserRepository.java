package com.project.portfolio.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
    Optional<User> findByUsername(String username);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.surname = :surname, u.username = :username, " +
            "u.aboutMe = :aboutMe, u.password = :password,u.passwordCreatedAt = :passwordCreatedAt, u.emailAddress = :emailAddress, u.detail = :detail " +
            "WHERE u.id = :id")
    void updateUser(@Param("id") int id,
                    @Param("name") String name,
                    @Param("surname") String surname,
                    @Param("username") String username,
                    @Param("aboutMe") String aboutMe,
                    @Param("password") String password,
                    @Param("emailAddress") String emailAddress,
                    @Param("passwordCreatedAt") LocalDateTime passwordCreatedAt,
                    @Param("detail") String detail);

}
