package com.ifelseco.cart.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    private String id;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CartItem> items=new ArrayList<>();

    private String email;

    private Date createdAt;
    private boolean expired;


}
