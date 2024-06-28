package com.itbrains.restaurantspringboot.dtos.booking;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingCreateDto {
    private String name;
    private int phoneNumber;
    private int numOfPeople;
    private Date requestDate;
    private String request;
}
