package com.dy.restaurant.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.restaurant.order.repository.dao.Cart;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-07-08
 */
@Transactional
public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findCartByUserName(String userName);

    Optional<Cart> findByCartId(String cartId);
}
