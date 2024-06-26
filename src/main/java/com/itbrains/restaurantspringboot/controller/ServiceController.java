package com.itbrains.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping("/home/service")
    public String index(){
        return "services";
    }
}
