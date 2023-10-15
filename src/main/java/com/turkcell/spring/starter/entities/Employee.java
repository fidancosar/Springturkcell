package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employee_id")
    private short employeeId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="title")
    private String title;

    @Column(name="title_of_courtesy")
    private String titleOfCourtesy;

    @Column(name="birth_date")
    private String birthDate;

    @Column(name="hire_date")
    private String hireDate;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="country")
    private String country;

    @Column(name="home_phone")
    private String homePhone;

    @Column(name="photo")
    private String extension;


    @Column(name="reports_to")
    private Short reportsTo;

    @Column(name="photo_path")
    private String photoPath;

    @OneToMany(mappedBy = "employees")
    private List<EmployeeTerritory> employeeTerritories;

    @OneToMany(mappedBy = "employees")
    private List<Order> orders;


}
