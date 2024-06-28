package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChefRepository extends JpaRepository<Chef, Long> {
    List<Chef> findTop4ByOrderByIdAsc();
}
