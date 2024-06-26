package com.itbrains.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    @GetMapping("/home/booking")
    public String index(){
        return "booking";
    }
}
