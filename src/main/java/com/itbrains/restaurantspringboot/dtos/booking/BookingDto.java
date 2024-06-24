package com.itbrains.restaurantspringboot.dtos.booking;

import lombok.Data;

import java.util.Date;
@Data
public class BookingDto {

    private String name;
    private int numOfPeople;
    private String request;
    private Date requestDate;
}
