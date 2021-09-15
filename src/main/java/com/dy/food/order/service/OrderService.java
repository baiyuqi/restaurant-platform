package com.dy.food.order.service;

import java.util.List;

import com.dy.food.order.web.CreateOrderRequest;
import com.dy.food.order.web.CreateOrderResponse;
import com.dy.food.order.web.PreviewOrderRequest;
import com.dy.food.order.web.PreviewOrderResponse;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-09-20
 */
public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest);

    CreateOrderResponse getOrderById(String orderId);

    List<CreateOrderResponse> getMyOrders();

    List<CreateOrderResponse> getAllOrders();
}
