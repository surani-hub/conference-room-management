package com.crm.conference.room.management.controller;

// Should be able to register new user.

import com.crm.conference.room.management.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestParam("userId") String userId) {
        userService.registerUser(userId);
        return ResponseEntity.ok("User registered successfully");
    }
}
