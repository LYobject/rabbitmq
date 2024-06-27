package com.li.mp.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/29 15:05
 * @Version 1.0
 */
public class Consumer {

    // 队列名称
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {


        // 1、创建一个连接工厂对象，用于创建连接
        ConnectionFactory factory = new ConnectionFactory();
        // 2、配置连接信息
        factory.setHost("localhost"); // 设置工厂IP，用于连接RabbitMQ
        factory.setUsername("admin"); // 设置用户名
        factory.setPassword("123"); // 设置密码
        // 3、创建连接（这一步需要抛异常，比如IP对应的RabbitMQ不存在或者说密码账号错误）
        Connection connection = factory.newConnection();
        // 4、获取信道
        Channel channel = connection.createChannel();
        // 5、接收消息
        /*
            1. 指定消费哪一个队列中的消息
            2. 消息接收成功后是否自动应答，true表示自动应答，false表示手动应答
            3. 消息接收成功时的回调
            4. 取消消息接收时的回调（可以理解为消息接收失败时的回调）
         */
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            // 消息成功消费后执行的逻辑（每成功消费一条消息都会执行一次这段逻辑）
            System.out.println("消息消费成功 "+message.toString());
            // System.out.println("消息消费成功 "+new String(message.getBody()));
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            // 消息消费中断后执行的逻辑（每中断消费一条消息都会执行一次这段逻辑）
            System.out.println("消息消费中断");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }

}
