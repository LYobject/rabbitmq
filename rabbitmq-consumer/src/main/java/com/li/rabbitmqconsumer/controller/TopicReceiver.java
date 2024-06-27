package com.li.rabbitmqconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName TopicReceiver
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 9:13
 * @Version 1.0
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "topic.man")
    public void TopicManReceiver (Map message) {
        System.out.println("TopicManReceiver消费者收到消息  : " + message.toString());
    }

    @RabbitListener(queues = "topic.woman")
    public void TopicTotalReceiver (Map message) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + message.toString());
    }
}
