package com.crm.conference.room.management.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime startTime;
    
    @Column(nullable = false)
    private LocalDateTime endTime;
    
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private ConferenceRoom room;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}