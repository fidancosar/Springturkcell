package com.turkcell.spring.starter.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderForListingDto {
    private int orderId;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private short shipVia;
    private String freight;
}
