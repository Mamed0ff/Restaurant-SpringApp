package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefShowDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodDto;
import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialShowDto;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.services.CategoryService;
import com.itbrains.restaurantspringboot.services.ChefService;
import com.itbrains.restaurantspringboot.services.EmailService;
import com.itbrains.restaurantspringboot.services.TestimontialService;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TestimontialService testimontialService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChefService chefService;

    @GetMapping("/home")
    public String index(Model model){
        List <CategoryDto> categories = categoryService.findTop3ByOrderByIdAsc();
        model.addAttribute("categories", categories);
        List<Food> breakfast = categoryService.findCategoryMenuById(1L).getFoods();
        List<Food> dinner = categoryService.findCategoryMenuById(2L).getFoods();
        List<Food> lunch = categoryService.findCategoryMenuById(3L).getFoods();
        model.addAttribute("breakfasts", breakfast);
        model.addAttribute("dinners", dinner);
        model.addAttribute("lunches", lunch);
        List<ChefShowDto> chefs=chefService.findTop4ByOrderByIdAsc();
        model.addAttribute("chefs", chefs);
        List<TestimonialShowDto> testimonials = testimontialService.findTop6ByOrderByIdAsc();
        model.addAttribute("testimonials", testimonials);
        return "home";
    }
}
