package com.dy.restaurant.order.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.dy.restaurant.order.repository.dao.CartItem;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-07-13
 */

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Modifying
    @Transactional
    void deleteByCartItemId(String cartItemId);

    Optional<CartItem> findByCartItemId(String cartItemId);
}
