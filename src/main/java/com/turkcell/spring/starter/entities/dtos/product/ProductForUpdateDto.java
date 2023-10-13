package com.turkcell.spring.starter.entities.dtos.product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "{productNameShouldNotBeBlank}")
    private String productName;
    private String quantityPerUnit;

    @PositiveOrZero(message = "{unitPriceShouldBePositive}")

    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
    //    private int categoryId;
    private int reorderLevel;
//    private short supplierId;
}