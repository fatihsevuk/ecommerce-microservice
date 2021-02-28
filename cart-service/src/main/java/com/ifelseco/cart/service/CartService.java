package com.ifelseco.cart.service;

import com.ifelseco.cart.entity.Cart;
import com.ifelseco.cart.model.CartModel;
import com.ifelseco.cart.model.CartItemModel;

public interface CartService {

    Cart save(Cart cart);
    void createUserCart(String email);
    Cart getCart();
    Cart addItemToCart(CartItemModel item);
    void deleteItemFormCart(Long itemId);
    Cart updateCart(CartModel cartModel);

}
