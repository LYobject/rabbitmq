package com.li.mp.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/29 14:51
 * @Version 1.0
 */
public class Producer {

    // 队列名称
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1、创建一个连接工厂对象，用于创建连接
        ConnectionFactory factory=new ConnectionFactory();
        // 2、配置连接信息
        factory.setHost("localhost");//设置工厂IP
        factory.setUsername("admin");// 设置用户名
        factory.setPassword("123");// 设置密码
        // 3、创建连接（这一步需要抛异常，比如IP对应的RabbitMQ不存在或者说密码账号错误）
        Connection connection = factory.newConnection();
        // 4、获取信道
        Channel channel = connection.createChannel();
        // 5、创建队列（这里直接采用了默认的交换机，所以不需要创建交换机）
        /*
            1. 队列名称
            2. 队列中的消息是否持久化（磁盘），默认取值为false，表示不持久化，此时消息存储在内存中
            3. 队列是否排他，true表示只能同一个连接中的信道使用，false表示不同连接的信道都可以使用该队列
            4. 是否自动删除，true表示当所有消费者与该队列断开了连接，队列会自动删除
            5. 其它参数
         */
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        String message = "Hello World!"; // 要发送的消息
        /*
            1. 指定要发送的交换机，空表示使用默认的交换机
            2. 指定将消息存放到哪一个队列
            3. 其它参数
            4. 指定本次要发送的消息
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送完毕！");


    }
}
