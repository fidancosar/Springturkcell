package com.turkcell.spring.starter.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductForListingDto {

    private int productId;
    private String productName;
    private String quantityPerUnit;
    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
    private int discontinued;
}
