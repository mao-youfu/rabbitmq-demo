package com.hand.rbtmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class TopicPublisher {
    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "Hello World!! routekey.1";
        // 发送到交换机
        channel.basicPublish(EXCHANGE_NAME, "routekey.1", null, message.getBytes());
        System.out.println(" Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
