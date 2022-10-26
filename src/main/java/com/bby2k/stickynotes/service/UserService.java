package com.bby2k.stickynotes.service;

import com.bby2k.stickynotes.dto.UserDTO;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.getUserById(id);
    }

    public void updateUser(User updatedUserDTO) {
        User user = userRepository.getOne(updatedUserDTO.getId());
        user.setEmail(updatedUserDTO.getEmail());
        user.setHashedPassword(updatedUserDTO.getHashedPassword());
        user.setUsername(updatedUserDTO.getUsername());
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public UserDTO getUserDTOById(UUID id) {
        User user = userRepository.getUserById(id);
        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getEmail());
        userDTO.convertBoards(user.getUsersBoardEntities());
        return userDTO;
    }
}
