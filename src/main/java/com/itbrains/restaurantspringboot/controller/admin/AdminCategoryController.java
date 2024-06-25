package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.category.CategoryCreateDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.models.Category;
import com.itbrains.restaurantspringboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;




    @GetMapping("/admin/category")
    public String adminCategory(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "admin/category/category";
    }



    @GetMapping("/admin/category/create")
    public String categoryCreate() {
        return "admin/category/category-create";
    }

    @PostMapping("/admin/category/create")
    public String categoryCreate(@ModelAttribute CategoryCreateDto categoryCreateDto) {
        categoryService.addCategory(categoryCreateDto);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/remove/{id}")
    public String categoryRemove(@PathVariable Long id) {
        categoryService.removeCategory(id);
        return "redirect:/admin/category";
    }


    @GetMapping("/admin/category/update/{id}")
    public String categoryUpdate(@PathVariable Long id,Model model){
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        model.addAttribute("category",categoryDto);
        return "admin/category/category-update";
    }

    @PostMapping("/admin/category/update")
    public String categoryUpdate(@ModelAttribute CategoryDto categoryDto){
        categoryService.updateCategory(categoryDto);
        return "redirect:/admin/category";
    }

}
