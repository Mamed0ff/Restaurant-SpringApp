package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialCreateDto;
import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialShowDto;

import java.util.List;

public interface TestimontialService {

    public void addTestimontial(TestimonialCreateDto testimonial, String userEmail);
    public List<TestimonialShowDto> findTop6ByOrderByIdAsc();
    public List<TestimonialShowDto> findAllTestimonials();
    public TestimonialShowDto findTestimonialById(Long id);
    public void deleteTestimonialById(Long id);
}
