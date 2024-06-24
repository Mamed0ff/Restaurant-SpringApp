package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.category.CategoryCreateDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    public void addCategory(CategoryCreateDto categoryCreateDto);
    public List<CategoryDto> getAllCategories();
    public void removeCategory(Long id);
    public CategoryDto getCategoryById(Long id);
    public void updateCategory(CategoryDto updatedCategoryDto);

}
