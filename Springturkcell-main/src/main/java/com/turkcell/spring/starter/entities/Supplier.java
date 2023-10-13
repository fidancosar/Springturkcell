package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="suppliers")
public class Supplier {

    @Id
    @GeneratedValue
    @Column(name="supplier_id")
    private short supplierId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_title")
    private String contactTitle;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="postalC_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    @Column(name="fax")
    private String fax;

    @Column(name="home_page")
    private String homePage;

    @OneToMany(mappedBy = "suppliers")
    private List<Product> products;


}
