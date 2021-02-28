package com.ifelseco.cart;

import com.ifelseco.cart.entity.Cart;
import com.ifelseco.cart.model.CartModel;
import com.ifelseco.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class CartServiceApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

    @Autowired
    private CartService cartService;


    @Override
    public void run(String... args) throws Exception {
        cartService.createUserCart("test@mail.com");

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
