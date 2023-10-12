package com.turkcell.spring.starter.entities.dtos.product;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForAddDto {
    private int productId;

    @Size(min=3)
    private String productName;

    private String quantityPerUnit;

    @PositiveOrZero(message = "Ürün fiyatı 0'dan büyük olmalıdır.")
    private double unitPrice;

    @Positive(message = "Ürün stok bilgisi pozitif bir değer almalıdır.")
    private Short unitInStock;

    private Short unitOnOrder;

   @NotNull
   @Min(1)
    private int categoryId;

    private int reOrderLevel;


    @NotNull
    @Min(1)
    private short supplierId;

}
