package com.dy.restaurant.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.restaurant.order.repository.dao.OrderItem;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
