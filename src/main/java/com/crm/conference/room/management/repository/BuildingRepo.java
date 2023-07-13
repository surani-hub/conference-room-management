package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.entity.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BuildingRepo extends JpaRepository<Building, Integer> {

    @Query("FROM Building b WHERE b.buildingName=:buildingName")
    Building findRoomsByBuildingName(String buildingName);
}
