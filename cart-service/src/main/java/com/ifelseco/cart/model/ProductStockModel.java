package com.ifelseco.cart.model;


import lombok.Data;

@Data
public class ProductStockModel {

    private BaseResponseModel baseResponseModel;
    private Long id;
    private String productName;
    private String productId;
    int qty;
    double price;
}
