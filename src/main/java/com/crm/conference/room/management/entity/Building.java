package com.crm.conference.room.management.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "buildings")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "building_name", nullable = false)
    private String buildingName;

}
