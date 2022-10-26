package com.bby2k.stickynotes.controller;

import com.bby2k.stickynotes.dto.UserDTO;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public UserDTO getUser(@PathVariable("id") UUID id) {
        return userService.getUserDTOById(id);
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping(value = "/user", consumes = {"application/json"})
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/user", consumes = {"application/json"})
    public void deleteUser(@RequestBody User user){
        userService.removeUser(user);
    }
}
