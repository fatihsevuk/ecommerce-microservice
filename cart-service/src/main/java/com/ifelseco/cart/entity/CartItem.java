package com.ifelseco.cart.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    private String id;


    private String name;
    private String brand;
    private BigDecimal price;
    private int qty;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne
    private Cart cart;

}
