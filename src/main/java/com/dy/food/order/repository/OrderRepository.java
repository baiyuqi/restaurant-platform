package com.dy.food.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.food.order.model.Order;

import java.util.List;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-09-18
 */
public interface OrderRepository extends CrudRepository<Order, String> {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(String userId);
}
