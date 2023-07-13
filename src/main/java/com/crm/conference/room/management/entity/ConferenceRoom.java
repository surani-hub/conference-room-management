package com.crm.conference.room.management.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conferenceRoom")
@Data
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "con_room_name")
    private String conRoomname;

    @Column(name = "room_status")
    private boolean isAvailable;
}
