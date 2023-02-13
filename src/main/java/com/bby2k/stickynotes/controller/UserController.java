package com.bby2k.stickynotes.controller;

import com.bby2k.stickynotes.dto.UserDTO;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // The user controller should be used for every user related requests.
    // The boards that are available to the given user shouldn't be loaded from the UserController!!!

//[GET REQUESTS]########################################################################################
    // - GET all users <ADMIN, SUPER_ADMIN>
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // - GET user by username <USER, ADMIN, SUPER_ADMIN>
    @GetMapping("/name/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name){
        return ResponseEntity.ok(userService.getUserByUsername(name));
    }

    // - GET user by email <USER, ADMIN, SUPER_ADMIN>
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    // - GET user by id <USER, ADMIN, SUPER_ADMIN>
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

//[POST REQUESTS]#########################################################################################

    //TODO: think about the authentication layers, if this belongs to the UserController.
    //TODO: Until that DO NOT IMPLEMENT!

    // - POST new user to the database <ANY>

    // - POST new role to user <SUPER_ADMIN>
    @PostMapping("/role")
    public ResponseEntity<Object> addRoleToUser(){
        return null;
    }

//[PUT REQUESTS]#########################################################################################

    // - PUT update user username <USER, ADMIN, SUPER_ADMIN>
    @PutMapping("/name")
    public ResponseEntity<Object> updateUsername(){
        return null;
    }

    // - PUT update user email <USER, ADMIN, SUPER_ADMIN>
    @PutMapping("/email")
    public ResponseEntity<Object> updateEmail(){
        return null;
    }

    // - PUT update user password <USER, ADMIN, SUPER_ADMIN>
    @PutMapping("/password")
    public ResponseEntity<Object> updatePassword(){
        return null;
    }

//[DELETE REQUESTS]#########################################################################################

    // - DELETE user (self delete) <ANY> !AUTHENTICATE!
    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteUser(){
        return null;
    }

    // - DELETE user (moderated) <ADMIN, SUPER_ADMIN>
    @DeleteMapping("/remove/name/{username}")
    public ResponseEntity<Object> deleteUserByUsername(@PathVariable String username){
        userService.removeUserByUsername(username);
        return ResponseEntity.ok("user with username [$s] was deleted.".formatted(username));
    }

    @DeleteMapping("/remove/email/{email}")
    public ResponseEntity<Object> deleteUserByEmail(@PathVariable String email){
        userService.removeUserByEmail(email);
        return ResponseEntity.ok("user with email [$s] was deleted.".formatted(email));
    }

    @DeleteMapping("/remove/id/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable UUID id){
        userService.removeUserById(id);
        return ResponseEntity.ok("user with id [$s] was deleted.".formatted(id));
    }

}
