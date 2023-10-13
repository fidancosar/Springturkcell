package com.turkcell.spring.starter.entities.dtos.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turkcell.spring.starter.entities.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
    @NotBlank(message = "{productNameShouldNotBeBlank}")
    private String productName;
    private String quantityPerUnit;
    @PositiveOrZero(message = "{unitPriceShouldBePositive}")
    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
    private int reorderLevel;
//    private int categoryId;
//    private Supplier suppliers;




}