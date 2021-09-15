package com.dy.food.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.food.order.repository.dao.OrderItem;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
