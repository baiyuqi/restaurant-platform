package com.dy.food.order.service;

import com.dy.food.order.repository.dao.CartItem;
import com.dy.food.order.web.CartItemRequest;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-17
 */
public interface CartItemService {

    void addCartItem(CartItemRequest cartItemRequest);
    void removeCartItem(String cartItemId);
    CartItem getCartItem(String cartItemId);
    void removeAllCartItems(String cartId);

}
