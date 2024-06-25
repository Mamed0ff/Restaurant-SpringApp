package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.category.CategoryCreateDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryDto;
import com.itbrains.restaurantspringboot.dtos.category.CategoryMenuDto;
import com.itbrains.restaurantspringboot.models.Category;
import com.itbrains.restaurantspringboot.repos.CategoryRepository;
import com.itbrains.restaurantspringboot.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCategory(CategoryCreateDto categoryCreateDto) {
        Category category = modelMapper.map(categoryCreateDto, Category.class);
        categoryRepository.save(category);

    }

    @Override
    public List<CategoryMenuDto> getAllMenuCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryMenuDto> categoryMenuDto = categories.stream().filter(x->x.isDeleted() == false).map(category-> modelMapper.map(category, CategoryMenuDto.class)).collect(Collectors.toList());
        return categoryMenuDto;
    }

    @Override
    public void removeCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        category.setDeleted(true);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void updateCategory(CategoryDto updatedCategoryDto) {
        Category category=categoryRepository.findById(updatedCategoryDto.getId()).orElseThrow();
        category.setName(updatedCategoryDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().filter(x->!x.isDeleted()).map(category-> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }
}
