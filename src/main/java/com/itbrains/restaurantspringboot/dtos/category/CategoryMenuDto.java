package com.itbrains.restaurantspringboot.dtos.category;

import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.models.Food;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryMenuDto {
    private long id;
    private String name;

    private List<FoodDto> foods=new ArrayList<>();
}
