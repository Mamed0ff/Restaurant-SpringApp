package com.itbrains.restaurantspringboot.dtos.food;

import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.models.Category;
import com.itbrains.restaurantspringboot.models.Chef;
import lombok.Data;

@Data
public class FoodDto {
    private long id;
    private String name;
    public String photoUrl;
    private double price;
    private CategoryDto category;
    private ChefDto chef;
}
