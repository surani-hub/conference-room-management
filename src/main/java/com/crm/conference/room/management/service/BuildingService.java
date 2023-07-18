package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.repository.BuildingRepo;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    private final BuildingRepo buildingRepository;

    public BuildingService(BuildingRepo buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public void addBuilding(String name) {
        Building building = new Building();
        building.setBuildingName(name);
        buildingRepository.save(building);
    }
}
