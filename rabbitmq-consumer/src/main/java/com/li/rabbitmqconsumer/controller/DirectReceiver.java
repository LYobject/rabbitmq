package com.li.rabbitmqconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName DirectReceiver
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/26 16:58
 * @Version 1.0
 */
// @Component
// @RabbitListener(queues = "directRabbitQueue")
// public class DirectReceiver {
//     @RabbitHandler
//     public void receive(Map message) {
//         System.out.println("第一个DirectReceiver消费者收到消息  : " + message.toString());
//     }
// }
