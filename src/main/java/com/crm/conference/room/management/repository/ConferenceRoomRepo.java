package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConferenceRoomRepo extends JpaRepository<ConferenceRoom, Integer> {

    @Query("FROM ConferenceRoom r WHERE r.status=:status")
    List<ConferenceRoom> findRoomsByStatus(@Param("status") String status);

}
