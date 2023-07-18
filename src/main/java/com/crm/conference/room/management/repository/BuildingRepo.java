package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BuildingRepo extends JpaRepository<Building, Long> {

    @Query("FROM Building b WHERE b.buildingName=:buildingName")
    Building findRoomsByBuildingName(String buildingName);

    Building findByName(String buildingName);
}
