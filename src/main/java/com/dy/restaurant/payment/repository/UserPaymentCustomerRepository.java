package com.dy.restaurant.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.restaurant.payment.repository.dao.UserPaymentCustomer;

/**
 * @author Yuqi.Bai, Date : 14-Dec-2020
 */
@Repository
public interface UserPaymentCustomerRepository extends JpaRepository<UserPaymentCustomer, String> {

    UserPaymentCustomer findByUserId(String userId);
}
