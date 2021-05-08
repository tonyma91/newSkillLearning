package com.laoma.rabbitmq.one2one_holleWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @author majinming@xiaomi.com
 * @description 消息生产
 * @date 2021年 03月24日 16:26
 */
import java.nio.charset.StandardCharsets;

public class Send {

    private final static String QUEUE_NAME = "hello";


    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            /**
             * 队列名字
             * 是否需要持久化
             * 是否独占链接，可以用于构建临时队列
             * 是否自动删除
             * 拓展参数，如队列的存货时间，一般为null
             */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            for (int i = 0; i < 50; i++) {
                // 消息内容
                String message = "task .. " + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(i * 2);
            }
            String message = "Hello World11!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}
