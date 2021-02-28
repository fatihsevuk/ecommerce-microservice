package com.ifelseco.stockapi.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int qty;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_id")
    private String productId;

    private double price;
}
