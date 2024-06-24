package com.itbrains.restaurantspringboot.dtos.booking;

import lombok.Data;

@Data
public class BookingCreateDto {
    private String name;
    private String email;
    private int numOfPeople;
    private String request;
}
