package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.booking.BookingCreateDto;
import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.models.Booking;

import java.util.List;

public interface BookingService {
    public void addBooking(BookingCreateDto bookingCreateDto);
    public List<BookingDto> getBookings();
    public void changeStatus(Long id);


}
