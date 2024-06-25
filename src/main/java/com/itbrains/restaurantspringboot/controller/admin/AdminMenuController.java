package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodCreateDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodUpdateDto;
import com.itbrains.restaurantspringboot.services.CategoryService;
import com.itbrains.restaurantspringboot.services.ChefService;
import com.itbrains.restaurantspringboot.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminMenuController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChefService chefService;

    @GetMapping("/admin/foods")
    public String menu(Model model) {
        List<FoodDto> foods = foodService.getAllFoods();
        model.addAttribute("foods", foods);
        return "admin/menu/menu";
    }


    @GetMapping("/admin/foods/create")
    public String foodCreate(Model model){
        List<CategoryDto> categories= categoryService.getAllCategory();
        List<ChefDto> chefs= chefService.getAllChefs();
        model.addAttribute("categories", categories);
        model.addAttribute("chefs", chefs);
        return "admin/menu/food-create";
    }

    @PostMapping("/admin/foods/create")
    public String foodCreate(@ModelAttribute FoodCreateDto foodCreateDto){
        foodService.addFood(foodCreateDto);
        return "redirect:/admin/foods";
    }


    @GetMapping("/admin/foods/remove/{id}")
    public String foodRemove(@PathVariable Long id){
        foodService.deleteFood(id);
        return "redirect:/admin/foods";
    }


    @GetMapping("/admin/foods/update/{id}")
    public String foodUpdate(@PathVariable Long id, Model model){
        FoodUpdateDto food = foodService.findUpdateFoodById(id);
        List<CategoryDto> categories = categoryService.getAllCategory();
        List<ChefDto> chefs = chefService.getAllChefs();
        model.addAttribute("categories", categories);
        model.addAttribute("chefs", chefs);
        model.addAttribute("food", food);
        return "admin/menu/food-update";
    }

    @PostMapping("/admin/foods/update")
    public String foodUpdate(@ModelAttribute FoodUpdateDto foodUpdateDto){
        foodService.updateFood(foodUpdateDto);
        return "redirect:/admin/foods";
    }
}
