package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.core.exception.BusinessException;
import com.turkcell.spring.starter.entities.*;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.order.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForUpdateDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;



    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getByOrderId(int OrderId) {
        return orderRepository.findById(OrderId).orElseThrow();

    }

    @Override
    public void deleteByOrderId(long deleteByOrderId) {
        orderRepository.deleteById((int) deleteByOrderId);

    }

    @Override
    public List<OrderForListingDto> orderListing() {
        return orderRepository.getOrder();
    }

    @Override
    public OrderForGetById orderId(int orderId) {
        return orderRepository.orderId(orderId);
    }

    @Override
    public Order updateOrder(int id, OrderForUpdateDto request) {
        Order order=orderRepository.findById(id).orElseThrow();
        order.setOrderId(request.getOrderId());
        order.setOrderDate(LocalDate.now());
        order.setRequiredDate(request.getRequiredDate());
        order.setShippedDate(request.getShippedDate());
        order.setFreight(request.getFreight());
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void add(OrderForAddDto request) {

//        Order order=Order.builder().
//                customers(Customer.builder().customerId(request.getCustomerId()).build())
//                .orderDate(LocalDate.now())
//                .employees(Employee.builder().employeeId(request.getEmployeeId()).build())
//                .requiredDate(request.getRequiredDate())
//                .shipAddress(request.getShipAddress())
//                .shipCity(request.getShipCity())
//                .shipName(request.getShipName())
//                .shipRegion(request.getShipRegion())
//                .build();
        Order orderFromAutoMapping = modelMapper.map(request, Order.class);


        orderFromAutoMapping = orderRepository.save(orderFromAutoMapping);

        // bu satırdan sonra order'ın id alanı set edilmiş..
        orderDetailService.addItemsToOrder(orderFromAutoMapping, request.getItems());
    }



    @Override
    public List<Object[]> getOrderProductName() {
        return orderRepository.getOrderProductName();
    }


    public void orderIdShouldNotMoreThan13000(int orderId){
        if(orderId>13000){
            throw new BusinessException("Ürün Id'si 13000'den büyük olamaz.");
        }
    }

    public void freightShouldBeLessThan7Char(String freight){
        if (freight.length()>7){
            throw new BusinessException("Belirtilen Freight alanı kurallara göre fazla");
        }
    }
    public void customerIdIsNotFound(String customerId){
        if(customerId.isEmpty()){
            throw new BusinessException("Yazılan id'ye ait bir customer bulunmamaktadır.");
        }
    }





}