package com.ifelseco.cart.controller;

import com.ifelseco.cart.entity.Cart;
import com.ifelseco.cart.model.BaseResponseModel;
import com.ifelseco.cart.model.CartModel;
import com.ifelseco.cart.model.CartItemModel;
import com.ifelseco.cart.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController implements CartOperations {

    private CartService cartService;
    private final ModelMapper modelMapper;

    public CartController(CartService cartService, ModelMapper modelMapper) {
        this.cartService = cartService;
        this.modelMapper = modelMapper;
    }

    @Override
    public CartModel getCart() {
        return modelMapper.map(cartService.getCart(),CartModel.class);
    }

    @Override
    public ResponseEntity<?> addItemToCart(CartItemModel item) {

        Cart cart=cartService.addItemToCart(item);

        if(cart!=null) {
            CartModel cartModel=modelMapper.map(cart,CartModel.class);
            return new ResponseEntity<>(cartModel, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new BaseResponseModel(400,"insufficient stocks"),HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public void deleteItem(String id) {
        cartService.deleteItemFormCart(Long.parseLong(id));
    }

    @Override
    public CartModel updateCart(CartModel cartModel) {
        return modelMapper.map(cartService.updateCart(cartModel),CartModel.class);
    }
}
