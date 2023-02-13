package com.bby2k.stickynotes.service;

import com.bby2k.stickynotes.dto.UserDTO;
import com.bby2k.stickynotes.dto.UserDTOMapper;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserDTOMapper userDTOMapper;

    public UserDTO getUserById(UUID id){
        return userRepository.getUserById(id)
                .map(userDTOMapper)
                .orElseThrow(() -> new RuntimeException(
                        "user with id [$s] not found".formatted(id)
                ));
    }

    public UserDTO getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username)
                .map(userDTOMapper)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user with name [$s] not found".formatted(username)
                ));
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userDTOMapper)
                .orElseThrow(() -> new RuntimeException(
                        "user with email [$s] not found".formatted(email)
                ));
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
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

    public void removeUserById(UUID uuid){
        userRepository.deleteById(uuid);
    }

    public void removeUserByUsername(String username){
        userRepository.deleteByUsername(username);
    }

    public void removeUserByEmail(String email){
        userRepository.deleteByEmail(email);
    }
//    public UserDTO getUserDTOById(UUID id) {
//        User user = userRepository.getUserById(id);
//        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getEmail());
//        userDTO.convertBoards(user.getUsersBoardEntities());
//        return userDTO;

//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Optional<User> loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
