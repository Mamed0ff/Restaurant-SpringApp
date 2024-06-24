package com.itbrains.restaurantspringboot.dtos.food;

import lombok.Data;

@Data
public class FoodMenuDto {
    private long id;
    private String name;
    public String photoUrl;
    private double price;
}
