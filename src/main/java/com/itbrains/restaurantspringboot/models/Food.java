package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    public String photoUrl;
    private double price;
    private int quantity = 1;

    @ManyToOne
    private Category category;
}
