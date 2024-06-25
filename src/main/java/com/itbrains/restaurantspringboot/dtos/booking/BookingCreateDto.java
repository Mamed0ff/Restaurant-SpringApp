package com.itbrains.restaurantspringboot.dtos.booking;

import lombok.Data;

@Data
public class BookingCreateDto {
    private String name;
    private int phoneNumber;
    private int numOfPeople;
    private String request;
}
