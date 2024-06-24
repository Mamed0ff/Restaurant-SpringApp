package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
