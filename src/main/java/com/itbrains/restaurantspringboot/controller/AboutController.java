package com.itbrains.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/home/about")
    public String index(){
        return "about";
    }
}
