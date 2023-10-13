package com.turkcell.spring.starter.business.abstracts;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.dtos.orderdetail.OrderDetailsForAddDto;

import java.util.List;

public interface OrderDetailService {
     void addItemsToOrder(Order order, List<OrderDetailsForAddDto> items);

}