package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.testimonial.TestimonialCreateDto;
import com.itbrains.restaurantspringboot.services.FoodService;
import com.itbrains.restaurantspringboot.services.TestimontialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TestimoialController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private TestimontialService testimontialService;

    @GetMapping("/home/testimonial")
    public String index(Model model){
        List<FoodMenuDto> foods =foodService.getFoodMenu();
        model.addAttribute("testimonials",testimontialService.findAllTestimonials());
        model.addAttribute("foods",foods);
        return "testimonials";
    }

    @PostMapping("/home/testimonial/create")
    public String create(@ModelAttribute TestimonialCreateDto testimonial, Principal principal){
        String email = principal.getName();
        testimontialService.addTestimontial(testimonial,email);
        return "redirect:/home/testimonial";
    }

}
