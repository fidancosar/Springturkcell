package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.OrderDetail;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.order.OrderForGetById;
import com.turkcell.spring.starter.entities.dtos.order.OrderForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.orderDto.OrderForListingDto" +
            "(o.orderId,o.orderDate, o.requiredDate, o.shippedDate, o.freight)" +
            "from Order o")
    List<OrderForListingDto> getOrder();

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.orderDto.OrderForGetById" +
            "(o.orderId,o.orderDate, o.requiredDate, o.shippedDate, o.freight)" +
            "from Order o where o.orderId= :orderId")

    OrderForGetById orderId( int orderId);


    @Query(value = "select p.product_id, p.unit_price from products p " +
            "inner join order_details od on od.product_id = p.product_id " +
            "inner join orders o on o.order_id = od.order_id " +
            "where p.product_id = :product_id", nativeQuery = true)
    List<OrderDetail> addOrderDetails(int product_id, Product product);

    @Query(value = "select o.order_id, p.product_name, od.quantity from orders o inner join " +
            "order_details od on o.order_id=od.order_id inner join Products p on od.product_id=p.product_id", nativeQuery = true)
    List<Object[]> getOrderProductName();
}