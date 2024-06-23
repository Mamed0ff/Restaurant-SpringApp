package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "foods", nullable = false)
    private List<Food> foods;
}
