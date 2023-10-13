package com.turkcell.spring.starter.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
@Entity
public class OrderDetail {


    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="quantity")
    private short quantity;

    @Column(name="discount")
    private float discount;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product products;

    @Id
    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    private Order orders;


}
