package com.ifelseco.cart.repository;

import com.ifelseco.cart.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
    Cart findCartByEmail(String email);
}
