package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;


    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="unit_in_stock")
    private Short unitInStock;

    @Column(name="unit_on_order")
    private Short unitOnOrder;

    @Column(name="reorder_level")
    private int reorderLevel;

    @Column(name="discontinued")
    private int discontinued;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category categories;//many product tek bir category'e gider.

    @OneToMany(mappedBy = "products")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    @JsonIgnore
    private Supplier suppliers;


}