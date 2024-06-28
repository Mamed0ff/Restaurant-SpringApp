package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    public String photoUrl;
    private double price;
    private int quantity = 1;
    private boolean isDeleted =false;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Chef chef;

    @ManyToMany(mappedBy = "foods")
    private List<Basket> baskets;

    @OneToMany(mappedBy = "food")
    private List<Testimonial> testimonials;

}
