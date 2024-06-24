package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.booking.BookingCreateDto;
import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.repos.BookingRepository;
import com.itbrains.restaurantspringboot.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addBooking(BookingCreateDto bookingCreateDto) {

    }

    @Override
    public List<BookingDto> getBookings() {
        return List.of();
    }

    @Override
    public void changeStatus(Long id) {

    }
}
