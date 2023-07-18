package com.crm.conference.room.management.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "floors")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int number;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

}
