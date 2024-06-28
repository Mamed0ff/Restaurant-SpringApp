package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    List<Testimonial> findTop6ByOrderByIdAsc();
}
