package com.dy.restaurant.order.service;

import java.util.List;

import com.dy.restaurant.order.web.CreateOrderRequest;
import com.dy.restaurant.order.web.CreateOrderResponse;
import com.dy.restaurant.order.web.PreviewOrderRequest;
import com.dy.restaurant.order.web.PreviewOrderResponse;

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
