package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.order.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.order.OrderForUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    //    List<Order> orderList=new ArrayList<>();
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> getAll= orderService.getAll();

        return new ResponseEntity<List<Order>>(getAll,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long deleteId){
        orderService.deleteByOrderId(deleteId);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<OrderForListingDto>> getOrder(){
        List<OrderForListingDto> getAll= orderService.orderListing();

        return new ResponseEntity<List<OrderForListingDto>>(getAll,HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public OrderForGetById getByOrderId(@PathVariable("id") int id){
        OrderForGetById getId= orderService.orderId(id);

        return getId;
    }
    @PutMapping("updateDto/{id}")
    public ResponseEntity<Order> orderUpdate(@PathVariable("id") int id, @RequestBody @Valid OrderForUpdateDto orderForUpdateDto){
        orderService.updateOrder(id,orderForUpdateDto);

        return new ResponseEntity<Order>(HttpStatus.CREATED);
    }


    @GetMapping("orderWithName")
    public List<Object[]> getOrderName(){

        return orderService.getOrderProductName();
    }

    @PostMapping
    public void add(@RequestBody @Valid OrderForAddDto request){
        orderService.add(request);
    }




}