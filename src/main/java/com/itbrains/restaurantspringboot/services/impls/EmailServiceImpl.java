package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.services.EmailService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendConfirmationEmail(String email) {
        UserEntity userEntity = userEntityService.findRealUserByEmail(email);
        String token = userEntity.getConfirmationToken();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rizvan.memmedov2004@gmail.com");
        message.setTo(email);
        message.setSubject("Confirmation email");
        String res = "http://localhost:9009/auth/confrim?email="+email+"&token="+token;
        message.setText(res);

        mailSender.send(message);


    }
}
