package com.crm.conference.room.management.controller;

import com.crm.conference.room.management.service.FloorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/floors")
public class FloorController {

    private final FloorService floorService;

    public FloorController(FloorService floorService) {

        this.floorService = floorService;
    }

    @PostMapping
    public ResponseEntity<?> addFloor(@RequestParam("buildingName") String buildingName,
                                      @RequestParam("floorNumber") int floorNumber) throws Exception {
        floorService.addFloor(buildingName, floorNumber);
        return ResponseEntity.ok("Floor added successfully");
    }
}