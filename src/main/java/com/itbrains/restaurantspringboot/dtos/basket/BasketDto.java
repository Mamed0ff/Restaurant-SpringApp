package com.itbrains.restaurantspringboot.dtos.basket;

import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BasketDto {
    private long id;
    private double totalPrice;

    private List<FoodDto> foods;
}
