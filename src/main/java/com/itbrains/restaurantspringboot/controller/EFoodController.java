package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.services.BasketService;
import com.itbrains.restaurantspringboot.services.CategoryService;
import com.itbrains.restaurantspringboot.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EFoodController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodService foodService;
    @Autowired
    private MenuController menuController;


    @GetMapping("/home/eFoods")
    public String index(){
        return "redirect:/home/eFoods/1";
    }

    @GetMapping("/home/eFoods/{id}")
    public String show(@PathVariable Long id, Model model){
        List<Food> foods = categoryService.findCategoryMenuById(id).getFoods();
        model.addAttribute("foods", foods);
        List<CategoryDto> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "category-foods";
    }

    @GetMapping("/home/eFoods/search")
    public String search( String keyword, Model model){
        List<FoodMenuDto> foods = foodService.searchFood(keyword);
        model.addAttribute("foods", foods);
        return "search-foods";
    }
}
