package com.turkcell.spring.starter.entities.dtos.order;

import com.turkcell.spring.starter.entities.dtos.orderdetail.OrderDetailsForAddDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderForAddDto {
 private String customerId; // Normalde giriş yapmış kullanıcı otomatik idsi alınır..
 private short employeeId;
 private LocalDate requiredDate;
 private short shipperId;
 private String shipName;
 private String shipAddress;
 private String shipCity;
 private String shipRegion;
 private List<OrderDetailsForAddDto> items;


}
