package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.booking.BookingCreateDto;
import com.itbrains.restaurantspringboot.dtos.booking.BookingDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.Booking;
import com.itbrains.restaurantspringboot.models.User;
import com.itbrains.restaurantspringboot.repos.BookingRepository;
import com.itbrains.restaurantspringboot.services.BookingService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addBooking(BookingCreateDto bookingCreateDto, String email) {
        UserDto userDto = userEntityService.findUserByEmail(email);
        User user = modelMapper.map(userDto, User.class);
       Booking booking = modelMapper.map(bookingCreateDto, Booking.class);
       booking.setUser(user);
       booking.setRequestDate(new Date());

       bookingRepository.save(booking);
    }

    @Override
    public List<BookingDto> getAvailableBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDto> bookingDtos = bookings.stream().filter(x-> !x.isCompleted() && !x.isCancelled())
                .map(booking -> modelMapper.map(booking,BookingDto.class)).collect(Collectors.toList());
        return bookingDtos;
    }

    @Override
    public void getCompleted(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setCompleted(true);
        bookingRepository.save(booking);

    }

    @Override
    public void getCancelled(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setCancelled(true);
        bookingRepository.save(booking);

    }

}
