package com.itbrains.restaurantspringboot.dtos.booking;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import lombok.Data;

import java.util.Date;
@Data
public class BookingDto {

    private long id;
    private String name;
    private int numOfPeople;
    private int phoneNumber;
    private String request;
    private Date requestDate;
    private UserDto user;
}
