package com.turkcell.spring.starter.entities.dtos.order;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForUpdateDto {

    private short orderId;
    @NotBlank(message = "Lütfen bir tarih giriniz.")
    private LocalDate orderDate;
    @NotBlank(message = "Lütfen tarih giriniz.")
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private short shipVia;
    private double freight;
}
