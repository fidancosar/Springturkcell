package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="region")
@Entity
public class Region {
    @Id
    @GeneratedValue
    @Column(name="region_id")
    private short regionId;

    @Column(name="region_description")
    private String regionDescription;

    @OneToMany(mappedBy = "regions")
    private List<Territory> territories;
}
