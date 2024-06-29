package com.challenge.cryptography.controller;

import com.challenge.cryptography.dtos.UserRequest;
import com.challenge.cryptography.dtos.UserResponse;
import com.challenge.cryptography.entity.User;
import com.challenge.cryptography.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request) {

        return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(userService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
