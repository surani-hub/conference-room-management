package com.crm.conference.room.management.repository;

import com.crm.conference.room.management.entity.Booking;
import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);
    List<Booking> findByRoomAndStartTimeBetween(ConferenceRoom room, LocalDateTime startTime, LocalDateTime endTime);
}
