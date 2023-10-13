package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.order.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForUpdateDto;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    void deleteByOrderId(long deleteByOrderId);
    List<OrderForListingDto> orderListing();
    OrderForGetById orderId(int orderId);
    Order updateOrder(int id, OrderForUpdateDto orderForUpdateDto);
    List<Object[]> getOrderProductName();
    void add(OrderForAddDto request);



}