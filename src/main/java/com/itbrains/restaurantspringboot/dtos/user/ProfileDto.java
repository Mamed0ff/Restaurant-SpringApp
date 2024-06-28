package com.itbrains.restaurantspringboot.dtos.user;

import com.itbrains.restaurantspringboot.models.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProfileDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoUrl;
    private boolean emailConfirmed=false;
    private String confirmationToken;

    private List<Order> orders;

    private List<Booking> bookings ;

    private Basket basket;

    private List<Testimonial> testimonials;
}
