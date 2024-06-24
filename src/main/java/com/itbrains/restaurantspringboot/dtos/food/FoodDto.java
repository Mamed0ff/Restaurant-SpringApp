package com.itbrains.restaurantspringboot.dtos.food;

import com.itbrains.restaurantspringboot.models.Category;
import com.itbrains.restaurantspringboot.models.Chef;
import lombok.Data;

@Data
public class FoodDto {
    private long id;
    private String name;
    public String photoUrl;
    private double price;
    private Category category;
    private Chef chefOfFood;
}