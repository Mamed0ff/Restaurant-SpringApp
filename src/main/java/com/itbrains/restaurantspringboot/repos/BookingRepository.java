package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Long> {
}
