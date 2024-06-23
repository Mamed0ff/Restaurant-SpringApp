package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "chefs")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
    private String speciality;
    private Date joinedDate;

}
