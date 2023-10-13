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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
//@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;

    @Autowired

    public OrderServiceImp(OrderRepository orderRepository, OrderDetailService orderDetailService, ModelMapper modelMapper, MessageSource messageSource) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
        this.modelMapper = modelMapper;
        this.messageSource = messageSource;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
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
        Order order = orderRepository.findById(id).orElseThrow();
        Order orderFromAutoMapping = modelMapper.map(request, Order.class);


        return orderRepository.save(orderFromAutoMapping);
//        order.setOrderId(request.getOrderId());
//        order.setOrderDate(LocalDate.now());
//        order.setRequiredDate(request.getRequiredDate());
//        order.setShippedDate(request.getShippedDate());
//        order.setFreight(request.getFreight());
//        return orderRepository.save(order);
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
        shipAddressShouldBeLessThan7Char(request.getShipAddress());
        customerIdIsNotFound(request.getCustomerId());

        Order orderFromAutoMapping = modelMapper.map(request, Order.class);
        orderFromAutoMapping = orderRepository.save(orderFromAutoMapping);  // gönderen hesaptan parayı düş

        // bu satırdan sonra order'ın id alanı set edilmiş..
        orderDetailService.addItemsToOrder(orderFromAutoMapping, request.getItems());
    }



    @Override
    public List<Object[]> getOrderProductName() {
        return orderRepository.getOrderProductName();
    }



    public void shipAddressShouldBeLessThan7Char(String shipAddress){
        if (shipAddress.length()<7){
            throw new BusinessException(messageSource.getMessage("shipAddressShouldBeLessThan7Char", new Object[]{"shipperAdress"}, LocaleContextHolder.getLocale()));
        }
    }
    public void customerIdIsNotFound(String customerId){
        if(customerId.isEmpty()){
            throw new BusinessException(messageSource.getMessage("customerIdIsNotFound", new Object[]{"customerId"}, LocaleContextHolder.getLocale()));
        }
    }





}