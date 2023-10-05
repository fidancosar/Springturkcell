package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_customer_demo")
public class CustomerCustomerDemo {


    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customers;

    @ManyToOne
    @JoinColumn(name="customer_type_id")
    @JsonIgnore
    private CustomerDemographic customerDemographics;
}

