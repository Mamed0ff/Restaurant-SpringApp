package com.itbrains.restaurantspringboot.dtos.booking;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BookingDto {

    private long id;
    private String name;
    private int numOfPeople;
    private int phoneNumber;
    private String request;
    private Date requestDate;
}
