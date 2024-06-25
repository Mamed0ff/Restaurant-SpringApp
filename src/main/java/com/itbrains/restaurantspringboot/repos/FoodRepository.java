package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository  extends JpaRepository<Food, Long> {
}
