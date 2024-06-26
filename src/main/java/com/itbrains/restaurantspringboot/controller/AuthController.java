package com.itbrains.restaurantspringboot.controller;


import com.itbrains.restaurantspringboot.dtos.user.RegisterDto;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping(value = "/login")
    public String login() {
        LOG.info("/login");

        LOG.info("Return login");
        return "login";
    }


    @GetMapping("/home/register")
    public String register() {
        return "register";
    }


    @PostMapping("/home/register")
    public String register(@ModelAttribute RegisterDto register) {
        userEntityService.register(register);
        return "redirect:/login";
    }
}
