package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.Booking;
import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.entity.User;
import com.crm.conference.room.management.repository.BookingRepo;
import com.crm.conference.room.management.repository.ConferenceRoomRepo;
import com.crm.conference.room.management.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepo bookingRepository;
    private final UserRepo userRepository;
    private final ConferenceRoomRepo conferenceRoomRepository;

    public BookingService(BookingRepo bookingRepository, UserRepo userRepository,
                          ConferenceRoomRepo conferenceRoomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    public void bookRoom(String userId, LocalDateTime startTime, LocalDateTime endTime, String buildingName,
                         int floorNumber, String roomId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new Exception("User not found");
        }

        ConferenceRoom room = conferenceRoomRepository.findByFloorAndRoomId(buildingName, floorNumber, roomId);
        if (room == null) {
            throw new Exception("Conference room not found");
        }

        List<Booking> conflictingBookings = bookingRepository.findByRoomAndStartTimeBetween(room, startTime, endTime);
        if (!conflictingBookings.isEmpty()) {
            throw new Exception("Room already booked for the given slot");
        }

        Booking booking = new Booking();
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setRoom(room);
        booking.setUser(user);
        bookingRepository.save(booking);
    }

    public void cancelBooking(String userId, LocalDateTime startTime, LocalDateTime endTime, String buildingName,
                              int floorNumber, String roomId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new Exception("User not found");
        }

        ConferenceRoom room = conferenceRoomRepository.findByFloorAndRoomId(buildingName, floorNumber, roomId);
        if (room == null) {
            throw new Exception("Conference room not found");
        }

        List<Booking> bookings = bookingRepository.findByUser(user);
        Optional<Booking> bookingOptional = bookings.stream()
                .filter(b -> b.getRoom().equals(room) && b.getStartTime().equals(startTime) &&
                        b.getEndTime().equals(endTime))
                .findFirst();

        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            bookingRepository.delete(booking);
        } else {
            throw new Exception("Booking not found");
        }
    }

    public List<Booking> getUserBookings(String userId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new Exception("User not found");
        }

        return bookingRepository.findByUser(user);
    }

    public List<ConferenceRoom> searchAvailableRooms(LocalDateTime startTime, LocalDateTime endTime,
                                                     String buildingName, Integer floorNumber, Integer capacity) {
        List<ConferenceRoom> availableRooms = new ArrayList<>();
        List<ConferenceRoom> rooms = conferenceRoomRepository.findByBuildingAndFloorAndCapacity(buildingName, floorNumber, capacity);

        for (ConferenceRoom room : rooms) {
            List<Booking> conflictingBookings = bookingRepository.findByRoomAndStartTimeBetween(room, startTime, endTime);
            if (conflictingBookings.isEmpty()) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

}
