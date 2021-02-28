package com.ifelseco.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    private int qty;
    private double price;
}
