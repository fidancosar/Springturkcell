package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForUpdateDto {


    private int productId;

    @NotBlank(message = "ürün ismi boş olamaz")
    private String productName;
    private String quantityPerUnit;

    @Positive(message = "ürün fiyatı pozitif olmalıdır.")

    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
//    private int categoryId;
    private int reorderLevel;
//    private short supplierId;
}
