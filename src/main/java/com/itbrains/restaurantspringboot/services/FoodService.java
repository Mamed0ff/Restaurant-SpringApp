package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.food.FoodCreateDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodUpdateDto;

import java.util.List;

public interface FoodService {
    public List<FoodMenuDto> getFoodMenu();
    public void addFood(FoodCreateDto foodCreateDto);
    public void updateFood(FoodUpdateDto foodUpdateDto);
    public void deleteFood(Long id);
}
