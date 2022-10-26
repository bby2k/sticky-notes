package com.bby2k.stickynotes.repository;

import com.bby2k.stickynotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserById(UUID uuid);
}
