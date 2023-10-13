package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shippers")
@Entity
public class Shipper {

    @Id
    @GeneratedValue
    @Column(name="shipper_id")
    private short shipperId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy = "shippers")
    private List<Order> orders;

}