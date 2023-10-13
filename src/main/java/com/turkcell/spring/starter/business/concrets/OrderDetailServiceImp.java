package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.orderdetail.OrderDetailsForAddDto;
import com.turkcell.spring.starter.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImp(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public void addItemsToOrder(Order order, List<OrderDetailsForAddDto> items) {
        for (OrderDetailsForAddDto item: items){
            OrderDetail od=OrderDetail.builder()
                    .products(Product.builder().productId(item.getProductId()).build())
                    .orders(Order.builder().orderId(order.getOrderId()).build())
                    .discount(0)
                    .quantity(item.getQuantity())
                    .unitPrice(0)// TODO: Find product and get unit price from productService
                    .build();
            orderDetailRepository.save(od);

        }
    }
}