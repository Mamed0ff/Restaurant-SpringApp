package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int phoneNumber;
    private int numOfPeople;
    private String request;
    private Date requestDate;
    private boolean isCompleted=false;
    private boolean isCancelled=false;

    @ManyToOne
    private UserEntity user;
}
