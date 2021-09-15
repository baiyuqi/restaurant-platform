package com.dy.restaurant.payment.service;

import com.dy.restaurant.payment.web.CreatePaymentRequest;
import com.dy.restaurant.payment.web.CreatePaymentResponse;

/**
 * @author Yuqi.Bai, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
