package com.dy.food.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dy.food.order.service.OrderService;
import com.dy.food.order.web.CreateOrderRequest;
import com.dy.food.order.web.CreateOrderResponse;
import com.dy.food.order.web.PreviewOrderRequest;
import com.dy.food.order.web.PreviewOrderResponse;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-07-14
 */
@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest) {

        CreateOrderResponse createOrderResponse = orderService.createOrder(createOrderRequest);
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<CreateOrderResponse> getOrderById(@PathVariable("orderId") String orderId) {

        CreateOrderResponse createOrderResponse = orderService.getOrderById(orderId);
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/order/myorders")
    public ResponseEntity<List<CreateOrderResponse>> getMyOrders() {

        List<CreateOrderResponse> createOrderResponse = orderService.getMyOrders();
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<List<CreateOrderResponse>> getAllOrders() {
        List<CreateOrderResponse> createOrderResponse = orderService.getAllOrders();
        return ResponseEntity.ok(createOrderResponse);
    }

    @PostMapping("/previewOrder")
    public ResponseEntity<PreviewOrderResponse> previewOrder(@RequestBody @Valid PreviewOrderRequest previewOrderRequest) {

        PreviewOrderResponse previewOrderResponse = orderService.previewOrder(previewOrderRequest);

        return ResponseEntity.ok(previewOrderResponse);
    }
}
