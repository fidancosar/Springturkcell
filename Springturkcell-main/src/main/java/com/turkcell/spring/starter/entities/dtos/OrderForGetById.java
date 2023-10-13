package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForGetById {

    @NotBlank(message = "customer id boş bırakılamaz.")

//    private String customerId;

    @NotBlank(message = "Employe id boş bırakılamaz.")
//    private short employeeId;
    private int orderId;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private short shipVia;
    private String freight;

}
