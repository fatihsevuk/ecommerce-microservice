package com.ifelseco.stock.model;


import lombok.Data;

@Data
public class ProductStockModel {

    private BaseResponseModel baseResponseModel;
    private Long id;
    private String productName;
    private String productId;
    private int qty;
    private double price;
}
