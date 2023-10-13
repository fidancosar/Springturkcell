package com.turkcell.spring.starter.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_categories")
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    @Column(name="product_product_id")
    private int productProductId;

    @Column(name="categories_category_id")
    private int categoryCategoryId;
}