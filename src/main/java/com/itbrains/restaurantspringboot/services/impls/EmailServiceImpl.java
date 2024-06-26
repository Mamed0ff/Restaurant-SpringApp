package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendConfirmationEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rizvan.memmedov2004@gmail.com");
        message.setTo(email);
        message.setSubject("Confirmation email");
        message.setText("Hello, " + email + "!");

        mailSender.send(message);


    }
}
