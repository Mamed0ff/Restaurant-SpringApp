package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.category.CategoryCreateDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;

import java.util.List;

public interface CategoryService {
    public void addCategory(CategoryCreateDto categoryCreateDto);
    public List<CategoryMenuDto> getAllMenuCategories();
    public void removeCategory(Long id);
    public CategoryDto getCategoryById(Long id);
    public void updateCategory(CategoryDto updatedCategoryDto);
    public List<CategoryDto> getAllCategory();

}
