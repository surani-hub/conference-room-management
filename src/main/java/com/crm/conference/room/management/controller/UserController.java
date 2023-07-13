package com.crm.conference.room.management.controller;

// Should be able to register new user.

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.entity.User;
import com.crm.conference.room.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    // https:localhost:8080/register
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    // Users should be able to list down all the conference rooms available in any building.
    // Eg:Alpha building has conference rooms with names: a1, a2, a3, a4 etc.

    @GetMapping("/listconrooms")
    public List<ConferenceRoom> getConferenceRoomsByStatus(@RequestParam("buildingName") String buildingName){

    }
}
