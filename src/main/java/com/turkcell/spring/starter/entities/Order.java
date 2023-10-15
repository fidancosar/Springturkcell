package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@Entity
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;//derste short denildi.


    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "required_date")
    private String requiredDate;

    @Column(name = "shipped_date")
    private String shippedDate;

//    @Column(name="ship_via")
//    private short shipVia;

    @Column(name = "freight")
    private String freight;//double da alınabilir.float da olur.real ise karşılığı

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship_postal_code")
    private String shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;


    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employees;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    @JsonIgnore
    private Shipper shippers;
}