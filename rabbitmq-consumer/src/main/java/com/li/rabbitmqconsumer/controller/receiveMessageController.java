package com.li.rabbitmqconsumer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName reciveMessageController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/26 16:51
 * @Version 1.0
 */
@RestController
@RequestMapping
public class receiveMessageController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // public String receiveMessage() {
    //     rabbitTemplate.get
    // }



}
