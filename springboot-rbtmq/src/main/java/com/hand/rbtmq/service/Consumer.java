package com.hand.rbtmq.service;

import com.hand.rbtmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
public class Consumer {


    @RabbitHandler
    public void listener(String msg){
        System.out.println("Receive Message: " + msg);
    }

}
