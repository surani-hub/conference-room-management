package com.crm.conference.room.management.controller;

import com.crm.conference.room.management.service.ConferenceRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conference-rooms")
public class ConferenceRoomController {

    private final ConferenceRoomService conferenceRoomService;

    public ConferenceRoomController(ConferenceRoomService conferenceRoomService) {
        this.conferenceRoomService = conferenceRoomService;
    }

    @PostMapping
    public ResponseEntity<?> addConferenceRoom(@RequestParam("buildingName") String buildingName,
                                               @RequestParam("floorNumber") int floorNumber,
                                               @RequestParam("roomId") String roomId) throws Exception {
        conferenceRoomService.addConferenceRoom(buildingName, floorNumber, roomId);
        return ResponseEntity.ok("Conference room added successfully");
    }
}