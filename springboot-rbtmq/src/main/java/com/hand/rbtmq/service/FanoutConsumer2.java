package com.hand.rbtmq.service;

import com.hand.rbtmq.config.FanoutRabbitMQConfig;
import com.hand.rbtmq.config.TopicRabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitMQConfig.QUEUE_NAME2)
public class FanoutConsumer2 {


    @RabbitHandler
    public void listener(String msg){
        System.out.println("Receive Topic Message2: " + msg);
    }

}
