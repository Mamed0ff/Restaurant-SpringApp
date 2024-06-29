package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodCreateDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodUpdateDto;
import com.itbrains.restaurantspringboot.models.Category;
import com.itbrains.restaurantspringboot.models.Chef;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.repos.ChefRepository;
import com.itbrains.restaurantspringboot.repos.FoodRepository;
import com.itbrains.restaurantspringboot.services.CategoryService;
import com.itbrains.restaurantspringboot.services.ChefService;
import com.itbrains.restaurantspringboot.services.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ChefService chefService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<FoodMenuDto> getFoodMenu() {
        List<Food> foods = foodRepository.findAll();
        List<FoodMenuDto> foodMenuDtos= foods.stream().filter(x->x.isDeleted()==false).map(food->modelMapper.map(food,FoodMenuDto.class)).collect(Collectors.toList());
        return foodMenuDtos;
    }

    @Override
    public void addFood(FoodCreateDto foodCreateDto) {
        Food food = new Food();
        food.setName(foodCreateDto.getName());
        food.setPhotoUrl(foodCreateDto.getPhotoUrl());
        food.setPrice(foodCreateDto.getPrice());
        Category category = categoryService.getRealCategoryById(foodCreateDto.getCategoryId());
        food.setCategory(category);
        Chef chef = chefService.getRealChefById(foodCreateDto.getChefId());
        food.setChef(chef);
        foodRepository.save(food);
    }

    @Override
    public void updateFood(FoodUpdateDto foodUpdateDto) {
        Food findFood = foodRepository.findById(foodUpdateDto.getId()).orElseThrow();
        findFood.setName(foodUpdateDto.getName());
        findFood.setPhotoUrl(foodUpdateDto.getPhotoUrl());
        findFood.setPrice(foodUpdateDto.getPrice());
        Category category = categoryService.getRealCategoryById(foodUpdateDto.getCategoryId());
        findFood.setCategory(category);
        Chef chef = chefService.getRealChefById(foodUpdateDto.getChefId());
        findFood.setChef(chef);
        foodRepository.save(findFood);
    }

    @Override
    public void deleteFood(Long id) {
        Food deletedFood = foodRepository.findById(id).orElseThrow();
        deletedFood.setDeleted(true);
        foodRepository.save(deletedFood);
    }

    @Override
    public FoodUpdateDto findUpdateFoodById(Long id) {
        Food findFood = foodRepository.findById(id).orElseThrow();
        return modelMapper.map(findFood,FoodUpdateDto.class);
    }

    @Override
    public List<FoodDto> getDeletedFoods() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDto> deletedFoodDtos= foods.stream().filter(x->x.isDeleted()==true).map(food->modelMapper.map(food,FoodDto.class)).collect(Collectors.toList());
        return deletedFoodDtos;
    }

    @Override
    public List<FoodDto> getAllFoods() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDto> foodDtos= foods.stream().filter(x->x.isDeleted()==false).map(food->modelMapper.map(food,FoodDto.class)).collect(Collectors.toList());
        return foodDtos;
    }

    @Override
    public FoodDto getFoodById(long id){
        Food food = foodRepository.findById(id).orElseThrow();
        return modelMapper.map(food,FoodDto.class);
    }

    @Override
    public Food getRealFoodById(Long id) {
        return foodRepository.findById(id).orElseThrow();
    }

    @Override
    public List<FoodMenuDto> searchFood(String keyword) {
        List<Food> foods = foodRepository.searchFood(keyword);
        List<FoodMenuDto> searchedFoods = foods.stream().filter(x->!x.isDeleted()).map(food->modelMapper.map(food,FoodMenuDto.class)).collect(Collectors.toList());
        return searchedFoods;
    }
}
