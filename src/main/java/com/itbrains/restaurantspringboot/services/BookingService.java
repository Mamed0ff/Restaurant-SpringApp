package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.booking.BookingCreateDto;
import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.models.Booking;

import java.util.List;

public interface BookingService {
    public void addBooking(BookingCreateDto bookingCreateDto, String email);
    public List<BookingDto> getAvailableBookings();
    public void getCompleted(Long id);
    public void getCancelled(Long id);


}
