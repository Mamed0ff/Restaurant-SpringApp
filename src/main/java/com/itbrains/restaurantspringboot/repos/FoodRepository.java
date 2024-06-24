package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository  extends CrudRepository<Food, Long> {
}
