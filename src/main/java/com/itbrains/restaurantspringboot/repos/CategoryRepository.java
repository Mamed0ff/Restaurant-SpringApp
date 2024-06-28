package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findTop3ByOrderByIdAsc();
}
