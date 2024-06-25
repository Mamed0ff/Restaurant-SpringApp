package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminBookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin/booking")
    public String adminBooking(Model model) {
        List<BookingDto> bookingDto = bookingService.getAvailableBookings();
        model.addAttribute("bookings", bookingDto);
        return "admin/bookings";
    }

    @GetMapping("/admin/booking/complete/{id}")
    public String bookingComplete(@PathVariable Long id) {
        bookingService.getCompleted(id);
        return "redirect:/admin/booking";
    }

    @GetMapping("/admin/booking/cancel/{id}")
    public String bookingCancel(@PathVariable Long id) {
        bookingService.getCancelled(id);
        return "redirect:/admin/booking";
    }
}
