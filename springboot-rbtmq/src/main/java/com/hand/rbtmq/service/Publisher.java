package com.hand.rbtmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送简单队列
     *
     * @param msg
     */
    public void publish(String routingKey, String msg) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String text = "Date time: " + simpleDateFormat.format(new Date()) + ", msg: " + msg;

        //简单对列的情况下routingKey即为Q名
        this.amqpTemplate.convertAndSend(routingKey, text);
    }


    public void publish(String exchange, String routingKey, String msg) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String text = "routingKey: " + routingKey + ", msg: " + msg + ", at " + simpleDateFormat.format(new Date());

        //简单对列的情况下routingKey即为Q名
        this.amqpTemplate.convertAndSend(exchange, routingKey, text);
    }


}
