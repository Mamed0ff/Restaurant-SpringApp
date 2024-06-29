package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository  extends JpaRepository<Food, Long> {
    @Query(value = "Select * from foods WHERE name LIKE %:search%", nativeQuery = true)
    List<Food> searchFood(String search);


}
