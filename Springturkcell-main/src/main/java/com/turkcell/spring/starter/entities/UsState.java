package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="us_states")
public class UsState {

    @Id
    @GeneratedValue
    @Column(name="state_id")
    private short stateId;

    @Column(name="state_name")
    private String stateName;

    @Column(name="state_abbr")
    private String stateAbbr;

    @Column(name="state_region")
    private String stateRegion;

}
