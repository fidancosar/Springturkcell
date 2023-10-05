package com.turkcell.spring.starter.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turkcell.spring.starter.entities.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForGetByIdDto {
    private int productId;
    private String productName;
    private String quantityPerUnit;
    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
    private int reorderLevel;
//    private int categoryId;
//    private Supplier suppliers;




}
