package com.hand.rbtmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FanoutRabbitMQConfig {
    public static final String QUEUE_NAME = "q_springboot_fanout_1";
    public static final String QUEUE_NAME2 = "q_springboot_fanout_2";
    public static final String EXCHANGE_NAME = "fanout_exchange_1";

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_NAME2);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
}
