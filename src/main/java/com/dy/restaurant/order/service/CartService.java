package com.dy.restaurant.order.service;

import com.dy.restaurant.order.repository.dao.Cart;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-17
 */
public interface CartService {

    Cart getCart();
    
    Cart getCartByCartId(String cartId);

    String createCart();

    Cart getCartByUserName(String userName);

}
