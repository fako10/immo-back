package com.immobelgo.repository;

import com.immobelgo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Optional<Users> findById(Long id);
    Optional<Users> findByUsernameAndValidationcode(String username, String validationCode);
    Boolean existsByEmail(String email);


    @Transactional
    @Modifying
    @Query("UPDATE Users a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
