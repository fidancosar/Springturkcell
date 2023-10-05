package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForUpdateDto {

    private int orderId;
    @NotBlank(message = "Lütfen bir tarih giriniz.")
    private String orderDate;
    @NotBlank(message = "Lütfen tarih giriniz.")
    private String requiredDate;
    private String shippedDate;
    private short shipVia;
    private String freight;
}
