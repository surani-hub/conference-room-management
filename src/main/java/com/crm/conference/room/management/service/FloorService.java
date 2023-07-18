package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.entity.Floor;
import com.crm.conference.room.management.repository.BuildingRepo;
import com.crm.conference.room.management.repository.FloorRepo;
import org.springframework.stereotype.Service;

@Service
public class FloorService {

    private final FloorRepo floorRepository;
    private final BuildingRepo buildingRepository;

    public FloorService(FloorRepo floorRepository, BuildingRepo buildingRepository) {
        this.floorRepository = floorRepository;
        this.buildingRepository = buildingRepository;
    }

    public void addFloor(String buildingName, int floorNumber) throws Exception {
        Building building = buildingRepository.findByName(buildingName);
        if (building == null) {
            throw new Exception("Building not found");
        }

        Floor floor = new Floor();
        floor.setNumber(floorNumber);
        floor.setBuilding(building);
        floorRepository.save(floor);
    }
}
