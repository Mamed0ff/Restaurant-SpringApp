package com.itbrains.restaurantspringboot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "chefs")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
    public String photoUrl;
    private String speciality;
    private Date joinedDate;
    @Column(columnDefinition = "boolean default true")
    private boolean isHere;


}
