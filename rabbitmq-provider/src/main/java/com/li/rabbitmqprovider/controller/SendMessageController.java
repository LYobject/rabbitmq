package com.li.rabbitmqprovider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/26 16:27
 * @Version 1.0
 */
@RestController
@RequestMapping
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        String messageId  = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> message=new HashMap<>();
        message.put("messageId",messageId);
        message.put("messageData",messageData);
        message.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("directRabbitExchange","TestDirectRouting", message);
        return "ok";
    }
    @RequestMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        String messageId  = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> message=new HashMap<>();
        message.put("messageId",messageId);
        message.put("messageData",messageData);
        message.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.man", message);
        return "ok";
    }


    @RequestMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        String messageId  = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> message=new HashMap<>();
        message.put("messageId",messageId);
        message.put("messageData",messageData);
        message.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.woman", message);
        return "ok";
    }

    @RequestMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        String messageId  = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> message=new HashMap<>();
        message.put("messageId",messageId);
        message.put("messageData",messageData);
        message.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("fanout.exchange",null,message);
        return "ok";
    }
    @GetMapping("/TestMessageAck")
    public String TestMessageAck() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("non-existent-exchange", "TestDirectRouting", map);
        return "ok";
    }
    @GetMapping("/TestMessageAck2")
    public String TestMessageAck2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);
        return "ok";
    }



}
