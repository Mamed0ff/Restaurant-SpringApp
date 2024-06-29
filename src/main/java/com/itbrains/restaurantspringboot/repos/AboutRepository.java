package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}
