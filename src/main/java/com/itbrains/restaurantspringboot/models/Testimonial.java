package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Date postedDate;
    private boolean isDeleted = false;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private Food food;
}
