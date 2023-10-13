package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForAddDto {
    private int productId;

    @NotBlank(message = "İsim girmek zorunludur.")
    private String productName;

    private String quantityPerUnit;

    @PositiveOrZero(message = "Ürün fiyatı 0'dan büyük olmalıdır.")
    private double unitPrice;

    @Positive(message = "Ürün stok bilgisi pozitif bir değer almalıdır.")
    private Short unitInStock;

    private Short unitOnOrder;

    //@NotBlank(message = "category id boş bırakılamaz")
    //@PositiveOrZero(message = "Lütfen pozitif bir değer giriniz.")
   // private int categoryId;

    private int reOrderLevel;

   // @NotBlank(message = "supplier id boş bırakılamaz")
   // @PositiveOrZero(message = "Lütfen pozitif bir değer giriniz.")
    //private short supplierId;

}
