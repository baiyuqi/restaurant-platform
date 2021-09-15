package com.dy.food.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.food.order.repository.dao.OrderBillingAddress;

/**
 * @author Yuqi.Bai, Date : 07-Dec-2020
 */
public interface OrderBillingAddressRepository extends CrudRepository<OrderBillingAddress, String> {
    OrderBillingAddress findByOrderId(String orderId);
}
