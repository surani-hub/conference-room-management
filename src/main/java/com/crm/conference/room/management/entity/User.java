package com.crm.conference.room.management.entity;

import lombok.Data;

import javax.persistence.*;

/* 1. Conference rooms are scattered across multiple buildings and multiple floors and each floor can have multiple conference rooms, but each conference room should be uniquely identifiable.
2. Booking will be done for slots in hours. Hours will be taken in 24 hours format eg. Book from 1am to 3am {1:3}, from 12pm to 1pm {12:13}
3. Each conference room can be booked given that no one has already booked for that slot.
4. User id should be mandatory for all operations.
5. Booking can be done for a maximum of 12 hours.


conference room - roomNo, roomName, availability, duration, getRoomAvailability(),
building - id, name, List<floor>,
floors - id, List<room>, getRooms
Booking - bookingId, slot, isAvailable(),
User - id, bookingStatus

*/
@Entity
@Table(name ="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
}
