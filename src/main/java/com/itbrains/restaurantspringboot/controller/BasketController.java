package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.basket.BasketItemDto;
import com.itbrains.restaurantspringboot.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;


    @GetMapping("/home/basket/add/{id}")
    public String addBasket(@PathVariable Long id, Principal principal) {
        String email = principal.getName();
        basketService.add(id,email);
        return "redirect:/home/eFoods";
    }

    @GetMapping("/home/basket/remove/{id}")
    public String removeBasket(@PathVariable Long id, Principal principal) {
        String email = principal.getName();
        basketService.remove(id,email);
        return "redirect:/home/eFoods";
    }
}
