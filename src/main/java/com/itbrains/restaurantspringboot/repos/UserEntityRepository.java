package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
