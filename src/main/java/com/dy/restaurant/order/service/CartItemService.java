package com.dy.restaurant.order.service;

import com.dy.restaurant.order.repository.dao.CartItem;
import com.dy.restaurant.order.web.CartItemRequest;

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
