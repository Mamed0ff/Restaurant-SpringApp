package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialReppository extends JpaRepository<Testimonial, Long> {
}
