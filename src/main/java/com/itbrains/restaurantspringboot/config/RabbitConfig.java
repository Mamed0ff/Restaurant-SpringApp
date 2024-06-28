package com.itbrains.restaurantspringboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String RESTORAN_FANOUT_EXCHANGE = "restoran_fanout_exchange";

    @Bean
    public FanoutExchange notificationFanoutExchange() {
        return new FanoutExchange(RESTORAN_FANOUT_EXCHANGE);
    }


    @Bean
    public Queue emailSenderQueue() {
        return new Queue("email-sender-queue");
    }

    @Bean
    public Queue userRoleGiverQueue(){
        return new Queue("user-role-giver-queue");
    }




    @Bean
    public Binding emailSenderBinding() {
        return BindingBuilder.bind(emailSenderQueue()).to(notificationFanoutExchange());
    }

    @Bean
    public Binding userRoleGiverBinding() {
        return BindingBuilder.bind(userRoleGiverQueue()).to(notificationFanoutExchange());
    }
}
