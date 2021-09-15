package com.dy.restaurant.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.restaurant.order.repository.dao.OrderShippingAddress;

/**
 * @author Yuqi.Bai, Date : 07-Dec-2020
 */
public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, String> {
    OrderShippingAddress findByOrderId(String orderId);
}
