package com.itbrains.restaurantspringboot.controller;


import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.dtos.user.ProfileDto;
import com.itbrains.restaurantspringboot.dtos.user.RegisterDto;
import com.itbrains.restaurantspringboot.models.Booking;
import com.itbrains.restaurantspringboot.models.Food;
import com.itbrains.restaurantspringboot.services.BookingService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping(value = "/login")
    public String login() {

        return "login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDto register) {

        userEntityService.register(register);
        return "redirect:/login";
    }

    @GetMapping("/home/profile")
    public String profile(Model model, Principal principal) {
        String email = principal.getName();
        ProfileDto profileDto = userEntityService.findProfileByEmail(email);
        model.addAttribute("profile", profileDto);
        List<Food> foods = profileDto.getBasket().getFoods();
        model.addAttribute("foods", foods);
        List<BookingDto> bookings = bookingService.getUserBookings(email);
        model.addAttribute("bookings", bookings);
        return "profile";
    }

    @GetMapping("auth/confirm")
    public String confirm(String email, String token)
    {
        boolean res = userEntityService.confirmEmail(email, token);
        return "redirect:/login";
    }


}
