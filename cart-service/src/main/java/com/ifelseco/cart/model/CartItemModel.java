package com.ifelseco.cart.model;

import com.ifelseco.cart.entity.Product;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "Item", description = "Cart Item Info")
public class CartItemModel {
    private String id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int qty;
    private ProductStockModel product;
}
