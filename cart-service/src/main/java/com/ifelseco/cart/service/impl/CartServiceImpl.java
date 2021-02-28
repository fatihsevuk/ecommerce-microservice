package com.ifelseco.cart.service.impl;

import com.ifelseco.cart.entity.Cart;
import com.ifelseco.cart.entity.CartItem;
import com.ifelseco.cart.model.CartModel;
import com.ifelseco.cart.model.CartItemModel;
import com.ifelseco.cart.model.ProductStockModel;
import com.ifelseco.cart.repository.CartRepository;
import com.ifelseco.cart.service.CartService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@Service
public class CartServiceImpl implements CartService {

    private static final Logger LOG = LoggerFactory.getLogger(CartServiceImpl.class);
    private CartRepository cartRepository;
    private RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public CartServiceImpl(CartRepository cartRepository, RestTemplate restTemplate, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }


    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void createUserCart(String email) {
        Cart cart=cartRepository.findCartByEmail(email);
        if(cart==null) {
            cart=new Cart();
            cart.setCreatedAt(new Date());
            cart.setExpired(false);
            cart.setEmail("test@mail.com");
            save(cart);
        }
    }

    @Override
    public Cart getCart() {
        return null;
    }

    @Override
    public Cart addItemToCart(CartItemModel item) {

        // Control stock
        ProductStockModel productStockModel=restTemplate.getForObject("http://stock-service:8181/api/stock/"+item.getProduct().getProductId(),ProductStockModel.class);
        if(productStockModel.getQty()>0) {
            Cart cart=cartRepository.findCartByEmail("test@mail.com");
            if(cart!=null) {
              CartItem cartItem=modelMapper.map(item, CartItem.class);
              cart.getItems().add(cartItem);
              return cartRepository.save(cart);
            }else {
                LOG.info("no cart");
                return null;
            }
        }else {
            LOG.info("insufficient stocks");
            return null;
        }


    }

    @Override
    public void deleteItemFormCart(Long itemId) {

    }

    @Override
    public Cart updateCart(CartModel cartModel) {
        return null;
    }
}
