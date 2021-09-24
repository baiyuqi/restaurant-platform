package com.dy.food.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dy.food.account.service.UserService;
import com.dy.food.good.service.GoodCategoryService;
import com.dy.food.good.service.GoodService;
import com.dy.food.good.web.GoodResponse;
import com.dy.food.order.repository.CartItemRepository;
import com.dy.food.order.repository.dao.Cart;
import com.dy.food.order.repository.dao.CartItem;
import com.dy.food.order.service.CartItemService;
import com.dy.food.order.service.CartService;
import com.dy.food.order.web.CartItemRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-07-13
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartService cartService;

    @Autowired
    GoodService catalogFeignClient;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserService accountFeignClient;

    @Override
    public void addCartItem(CartItemRequest cartItemRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) authentication.getPrincipal();
        Cart cartByUserName = cartService.getCartByUserName(userName);

        synchronized (CartServiceImpl.class) {
            if (cartByUserName == null) {
                //create cart for user if not exists.
                cartService.createCart();
                cartByUserName = cartService.getCartByUserName(userName);
            }
        }
    
        GoodResponse getGoodResponse = catalogFeignClient.getGood(cartItemRequest.getGoodId());

        if (cartItemRequest.getQuantity() > getGoodResponse.getAvailableItemCount()) {
            throw new RuntimeException("Quantity is greater than available item count!");
        }

        //If the good already exists in the cart, update its quantity and itemPrice.

        if (cartByUserName.getCartItems() != null) {
            for (CartItem ci : cartByUserName.getCartItems()) {
    
                if (getGoodResponse.getGoodId().equals(ci.getGoodId())) {
                    ci.setQuantity(cartItemRequest.getQuantity());
                    ci.setItemPrice(getGoodResponse.getPrice());
                    ci.setExtendedPrice(ci.getQuantity() * getGoodResponse.getPrice());
                    cartItemRepository.save(ci);
                    return;
                }
            }
        }

        //If cart doesn't have any cartItems, then create cartItems.
        CartItem cartItem = CartItem.builder()
                                    .cart(cartByUserName)
                                    .itemPrice(getGoodResponse.getPrice())
                                    .extendedPrice(cartItemRequest.getQuantity() * getGoodResponse.getPrice())
                                    .quantity(cartItemRequest.getQuantity())
                                    .goodId(getGoodResponse.getGoodId())
                                    .goodName(getGoodResponse.getGoodName())
                                    .build();

        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(String cartItemId) {
        CartItem cartItem = this.getCartItem(cartItemId);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem getCartItem(String cartItemId) {
        Optional<CartItem> byCartItemId = cartItemRepository.findByCartItemId(cartItemId);
        return byCartItemId.orElseThrow(()-> new RuntimeException("CartItem doesn't exist!!"));
    }

    @Override
    public void removeAllCartItems(String cartId) {

        Cart cart = cartService.getCartByCartId(cartId);
        List<String> cartItemIds = cart.getCartItems().stream().map(cartItem -> cartItem.getCartItemId()).collect(Collectors.toList());
        if (!cartItemIds.isEmpty()) {
            cartItemIds.forEach(this::removeCartItem);
        }
    }
}
