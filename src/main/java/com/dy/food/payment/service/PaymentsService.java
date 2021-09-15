package com.dy.food.payment.service;

import com.dy.food.payment.web.CreatePaymentRequest;
import com.dy.food.payment.web.CreatePaymentResponse;

/**
 * @author Yuqi.Bai, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
