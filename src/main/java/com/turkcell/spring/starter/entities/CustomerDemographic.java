package com.turkcell.spring.starter.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_demographics")
public class CustomerDemographic {

    @Id
    @GeneratedValue
    @Column(name="customer_type_id")
    private String customerTypeId;

    @Column(name="customer_desc")
    private String customerDesc;

    @OneToMany(mappedBy = "customerDemographics")
    private List<CustomerCustomerDemo> customerCustomerDemos;
}