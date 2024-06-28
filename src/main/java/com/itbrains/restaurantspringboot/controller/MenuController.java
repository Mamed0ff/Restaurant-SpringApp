package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PrivateKey;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home/menu")
    public String index(Model model){

        List<CategoryMenuDto> categoryMenuDtoList = categoryService.getAllMenuCategories();
        model.addAttribute("categoryMenuList", categoryMenuDtoList);
        return "menu";
    }
}
