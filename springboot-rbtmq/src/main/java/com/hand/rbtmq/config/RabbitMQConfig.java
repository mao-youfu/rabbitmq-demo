package com.hand.rbtmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "q_springboot";

    @Bean
    public Queue getQueue(){
        return new Queue(QUEUE_NAME);
    }
}
