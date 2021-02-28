package com.ifelseco.cart.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "Cart", description = "Cart Info")
public class CartModel {
    private String id;
    private List<CartItemModel> items=new ArrayList<>();
    private Date createdAt;
    private boolean expired;

}
