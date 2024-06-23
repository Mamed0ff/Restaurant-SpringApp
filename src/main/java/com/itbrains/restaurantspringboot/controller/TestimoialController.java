package com.itbrains.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimoialController {

    @GetMapping("/testimonial")
    public String index(){
        return "testimonials";
    }
}
