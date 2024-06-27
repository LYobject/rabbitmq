package com.li.rabbitmqconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName FanoutReceiver
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 10:03
 * @Version 1.0
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanout.A")
    public void  ReceiveA(Map message){
        System.out.println("Fanout A"+message.toString());
    }
    @RabbitListener(queues = "fanout.B")
    public void  ReceiveB(Map message){
        System.out.println("Fanout B"+message.toString());
    }
    @RabbitListener(queues = "fanout.C")
    public void  ReceiveC(Map message){
        System.out.println("Fanout C"+message.toString());
    }
}
