package com.itbrains.restaurantspringboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminBookingController {


    @GetMapping("/admin/booking")
    public String adminBooking() {
        return "admin/bookings";
    }
}
