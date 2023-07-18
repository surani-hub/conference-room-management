package com.crm.conference.room.management.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "conference_rooms")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_id")
    private String roomId;

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;
}
