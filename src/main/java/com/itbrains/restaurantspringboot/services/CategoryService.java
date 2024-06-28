package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.category.CategoryCreateDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryUpdateDto;
import com.itbrains.restaurantspringboot.models.Category;

import java.util.List;

public interface CategoryService {
    public void addCategory(CategoryCreateDto categoryCreateDto);
    public List<CategoryMenuDto> getAllMenuCategories();
    public void removeCategory(Long id);
    public CategoryDto getCategoryById(Long id);
    public void updateCategory(CategoryUpdateDto updatedCategoryDto);
    public List<CategoryDto> getAllCategory();
    Category getRealCategoryById(Long id);
    List<CategoryDto> findTop3ByOrderByIdAsc();
    CategoryMenuDto findCategoryMenuById(Long id);

}
