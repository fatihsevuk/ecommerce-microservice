package com.ifelseco.stock.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    private String id;

    private String name;

}
