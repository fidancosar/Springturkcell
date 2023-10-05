package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.OrderForAddDto;
import com.turkcell.spring.starter.entities.dtos.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.OrderForListingDto;
import com.turkcell.spring.starter.entities.dtos.OrderForUpdateDto;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/save")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order addOrder= orderService.addOrder(order);
        return new ResponseEntity<Order>(addOrder,HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> getAll= orderService.getAll();
        return new ResponseEntity<List<Order>>(getAll,HttpStatus.OK);

    }
    @GetMapping("/id")
    public ResponseEntity<Order>getById(@PathVariable("id") long getById ){
        Order getByOrderId=orderService.getByOrderId(getById);
        return new ResponseEntity<Order>(getByOrderId,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long deleteId){
        orderService.deleteByOrderId(deleteId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<OrderForListingDto>> getOrder(){
        List<OrderForListingDto> getAll= orderService.orderListing();
        return new ResponseEntity<List<OrderForListingDto>>(getAll,HttpStatus.OK);
    }
//    @GetMapping("getById/{id}")
//    public ResponseEntity<List<OrderForGetById>> getOrderId(@PathVariable("id") int orderId){
//        List<OrderForGetById> getOrderId=orderService.orderId(orderId);
//        return new ResponseEntity<List<OrderForGetById>>(getOrderId,HttpStatus.OK);
//    }
    @GetMapping("getById")
    public OrderForGetById getByOrderId( int id){
        OrderForGetById getId= orderService.orderId(id);
       return getId;
    }
    @PutMapping("updateDto/{id}")
    public ResponseEntity<Order> orderUpdate(@PathVariable("id") int id, @RequestBody @Valid OrderForUpdateDto orderForUpdateDto){
        orderService.updateOrder(id,orderForUpdateDto);
        return new ResponseEntity<Order>(HttpStatus.CREATED);
    }
    @PostMapping("saveOrderDto")
    public ResponseEntity addForOrderDto(@RequestBody @Valid OrderForAddDto orderForAddDto){
        orderService.addOrderDto(orderForAddDto);
        return new ResponseEntity("ürün eklendi", HttpStatus.CREATED);
    }

    @PostMapping("addOrderDetails/{id}")
    public ResponseEntity<List<OrderDetail>> addOrderDetails(@PathVariable("id") int id, Product product) {
        orderService.addOrderDetails(id, product);
        return new ResponseEntity<List<OrderDetail>>(HttpStatus.CREATED);
    }
    @GetMapping("orderWithName")
    public List<Object[]> getOrderName(){
        return orderService.getOrderProductName();
    }
    @PostMapping("abc")
    public ResponseEntity addProductToOrder(int orderId, int productId, short quantity){
        orderService.addProductToOrder(orderId, productId, quantity);
        return new ResponseEntity(HttpStatus.CREATED);
    }






//    @GetMapping("order")
//    public List<Order> getOrderList() {
//
//        return orderList ;
//    }
//    @PostMapping("order")
//    public ResponseEntity addOrder(@RequestBody Order order) {
//        //built in-Hali hazırda mevcut class
//        if (order.getOrderId() <= 0) {
//            return new ResponseEntity<>("Eklenecek sipariş id'si 0'dan büyük olmalıdır", HttpStatus.BAD_REQUEST);
//        }
//        orderList.add(order);
//
//        return new ResponseEntity(order.getOrderId() + " kategori eklendi",  HttpStatus.CREATED);
//
//    }
//    @GetMapping("getAll")
//    public List<Order> orders(){
//        return orderService.getAll();
//    }

}
