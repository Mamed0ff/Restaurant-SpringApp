package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.food.FoodCreateDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodUpdateDto;
import com.itbrains.restaurantspringboot.models.Food;

import java.util.List;

public interface FoodService {
    public List<FoodMenuDto> getFoodMenu();
    public void addFood(FoodCreateDto foodCreateDto);
    public void updateFood(FoodUpdateDto foodUpdateDto);
    public void deleteFood(Long id);
    public FoodUpdateDto findUpdateFoodById(Long id);
    public List<FoodDto> getDeletedFoods();
    public List<FoodDto> getAllFoods();
    public FoodDto getFoodById(long id);
    Food getRealFoodById(Long id);
}
