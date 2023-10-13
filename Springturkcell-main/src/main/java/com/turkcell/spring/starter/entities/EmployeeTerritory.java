package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_territories")
public class EmployeeTerritory {


    @Id
    @ManyToOne
    @JoinColumn(name="employee_id")
    @JsonIgnore
    private Employee employees;


    //Id alacak mı burası??
    @ManyToOne
    @JoinColumn(name="territory_id")
    @JsonIgnore
    private Territory territories;
}




