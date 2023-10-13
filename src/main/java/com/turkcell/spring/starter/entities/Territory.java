package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="territories")
public class Territory {

    @Id
    @GeneratedValue
    @Column(name="territory_id")
    private String territoryId;

    @Column(name="territory_description")
    private String territoryDescription;

    @OneToMany(mappedBy = "territories")
    private List<EmployeeTerritory> employeeTerritories;

    @ManyToOne
    @JoinColumn(name="region_id")
    @JsonIgnore
    private Region regions;

}