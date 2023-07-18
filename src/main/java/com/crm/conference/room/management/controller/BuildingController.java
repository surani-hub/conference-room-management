package com.crm.conference.room.management.controller;

import com.crm.conference.room.management.service.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {

        this.buildingService = buildingService;
    }

    @PostMapping
    public ResponseEntity<?> addBuilding(@RequestParam("name") String name) {
        buildingService.addBuilding(name);
        return ResponseEntity.ok("Building added successfully");
    }
}