package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @Autowired
    private ChefService chefService;

    @GetMapping("/home/team")
    public String index(Model model){
        model.addAttribute("chefs", chefService.getAllChefs());
        return "team";
    }
}
