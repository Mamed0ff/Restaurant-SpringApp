package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {
}
