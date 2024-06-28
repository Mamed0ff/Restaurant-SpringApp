package com.itbrains.restaurantspringboot.dtos.food;

import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefShowDto;
import lombok.Data;

@Data
public class FoodMenuDto {
    private long id;
    private String name;
    public String photoUrl;
    private double price;
    private ChefShowDto chef;
}
