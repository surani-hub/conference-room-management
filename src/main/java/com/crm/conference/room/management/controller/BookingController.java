package com.crm.conference.room.management.controller;

import com.crm.conference.room.management.entity.Booking;
import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> bookRoom(@RequestParam("userId") String userId,
                                      @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                      @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
                                      @RequestParam("buildingName") String buildingName,
                                      @RequestParam("floorNumber") int floorNumber,
                                      @RequestParam("roomId") String roomId) throws Exception {
        bookingService.bookRoom(userId, startTime, endTime, buildingName, floorNumber, roomId);
        return ResponseEntity.ok("Room booked successfully");
    }

    @DeleteMapping
    public ResponseEntity<?> cancelBooking(@RequestParam("userId") String userId,
                                           @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                           @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
                                           @RequestParam("buildingName") String buildingName,
                                           @RequestParam("floorNumber") int floorNumber,
                                           @RequestParam("roomId") String roomId) throws Exception {
        bookingService.cancelBooking(userId, startTime, endTime, buildingName, floorNumber, roomId);
        return ResponseEntity.ok("Booking canceled successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable("userId") String userId) throws Exception {
        List<Booking> bookings = bookingService.getUserBookings(userId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ConferenceRoom>> searchAvailableRooms(
            @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
            @RequestParam(value = "buildingName", required = false) String buildingName,
            @RequestParam(value = "floorNumber", required = false) Integer floorNumber,
            @RequestParam(value = "capacity", required = false) Integer capacity) {
        List<ConferenceRoom> rooms = bookingService.searchAvailableRooms(startTime, endTime, buildingName, floorNumber, capacity);
        return ResponseEntity.ok(rooms);
    }
}