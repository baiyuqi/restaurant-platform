package com.dy.food.payment.service;

import java.util.List;

import com.dy.food.payment.web.CreatePaymentMethodRequest;
import com.dy.food.payment.web.GetPaymentMethodResponse;

/**
 * @author Yuqi.Bai, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
