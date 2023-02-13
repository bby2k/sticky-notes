package com.bby2k.stickynotes.repository;

import com.bby2k.stickynotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User save(User user);

    UserDetails findByUsername(String username);

    Optional<User> getUserById(UUID uuid);
    Optional<User> getUserByUsername(String username);

    Optional<User> findByEmail(String email);

    void delete(User user);

    void deleteByUsername(String username);

    void deleteByEmail(String email);
}
