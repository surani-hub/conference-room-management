package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConferenceRoomRepo extends JpaRepository<ConferenceRoom, Integer> {

    @Query("FROM ConferenceRoom r WHERE r.status=:status")
    List<ConferenceRoom> findRoomsByStatus(@Param("status") String status);

    List<ConferenceRoom> findByFloor(Floor floor);

    ConferenceRoom findByFloorAndRoomId(String buildingName, int floorNumber, String roomId);

    List<ConferenceRoom> findByBuildingAndFloorAndCapacity(String buildingName, Integer floorNumber, Integer capacity);
}
