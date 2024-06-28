package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialCreateDto;
import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialShowDto;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.models.Testimonial;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.TestimonialRepository;
import com.itbrains.restaurantspringboot.services.FoodService;
import com.itbrains.restaurantspringboot.services.TestimontialService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimontialService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FoodService foodService;

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private UserEntityService userService;

    @Override
    public void addTestimontial(TestimonialCreateDto testimonial, String userEmail) {
        Testimonial newTestimonial = new Testimonial();
        newTestimonial.setDescription(testimonial.getDescription());
        newTestimonial.setPostedDate(new Date());
        Food food = foodService.getRealFoodById(testimonial.getFoodId());
        newTestimonial.setFood(food);
        UserEntity user= userService.findRealUserByEmail(userEmail);
        newTestimonial.setUser(user);
        testimonialRepository.save(newTestimonial);

    }

    @Override
    public List<TestimonialShowDto> findTop6ByOrderByIdAsc() {
        List<Testimonial> testimonials = testimonialRepository.findTop6ByOrderByIdAsc();
        List<TestimonialShowDto> testimonialShowDtos=testimonials.stream().map(tes->modelMapper.map(tes,TestimonialShowDto.class)).collect(Collectors.toList());
        return testimonialShowDtos;
    }

    @Override
    public List<TestimonialShowDto> findAllTestimonials() {
        List<Testimonial> testimonials = testimonialRepository.findAll();
        List<TestimonialShowDto> testimonialShowDtos=testimonials.stream().filter(x-> !x.isDeleted()).map(tes->modelMapper.map(tes,TestimonialShowDto.class)).collect(Collectors.toList());
        return testimonialShowDtos;
    }

    @Override
    public TestimonialShowDto findTestimonialById(Long id) {
        Testimonial testimonial= testimonialRepository.findById(id).orElseThrow();
        return modelMapper.map(testimonial,TestimonialShowDto.class);
    }

    @Override
    public void deleteTestimonialById(Long id) {
        Testimonial testimonial= testimonialRepository.findById(id).orElseThrow();
        testimonial.setDeleted(true);
        testimonialRepository.save(testimonial);
    }



}
