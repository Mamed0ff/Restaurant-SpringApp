package com.itbrains.restaurantspringboot.controller;

import com.itbrains.restaurantspringboot.dtos.booking.BookingCreateDto;
import com.itbrains.restaurantspringboot.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;



    @GetMapping("/home/booking")
    public String index(){
        return "booking";
    }

    @PostMapping("/home/booking")
    public String booking(@ModelAttribute BookingCreateDto booking, Principal principal){
        String username = principal.getName();
        bookingService.addBooking(booking, username);
        return "redirect:/home";
    }

    @GetMapping("/home/booking/cancel/{id}")
    public String bookingCancel(@PathVariable Long id) {
        bookingService.getCancelled(id);
        return "redirect:/home/profile";
    }
}
