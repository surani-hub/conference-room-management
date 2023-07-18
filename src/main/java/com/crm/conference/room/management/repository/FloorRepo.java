package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorRepo extends JpaRepository<Floor, Long> {

    List<Floor> findByBuilding(Building building);

    Floor findByBuildingAndNumber(String buildingName, int floorNumber);
}
