package com.hand.springrbtmq.listener;


public class MessageListener {

    public void listen(String message) {
        System.out.println("message: " + message);
    }
}
