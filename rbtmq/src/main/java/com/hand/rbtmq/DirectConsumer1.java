package com.hand.rbtmq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class DirectConsumer1 {
    private final static String QUEUE_NAME = "test_queue_direct1";

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        final Channel channel = connection.createChannel();


        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);

                String msg = new String(body);

                // 反馈消费状态，确认消息已消费
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println(msg);
                //从message池中获取msg对象更高效
//                Message uimsg = handler.obtainMessage();
//                Bundle bundle = new Bundle();
//                bundle.putString("msg", msg);
//                uimsg.setData(bundle);
//                handler.sendMessage(uimsg);

            }
        });
    }

}
