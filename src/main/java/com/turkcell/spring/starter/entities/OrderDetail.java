package com.turkcell.spring.starter.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
@Entity
@Builder
public class OrderDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="quantity")
    private short quantity;

    @Column(name="discount")
    private float discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product products;


    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    private Order orders;

}
