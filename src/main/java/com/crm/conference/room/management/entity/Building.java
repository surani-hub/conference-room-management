package com.crm.conference.room.management.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
@Data
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "building_name")
    private String buildingName;

    @OneToMany
    private List<ConferenceRoom> conferenceRoom;
}
