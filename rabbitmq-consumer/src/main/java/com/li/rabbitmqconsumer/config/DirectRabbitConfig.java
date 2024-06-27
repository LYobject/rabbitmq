package com.li.rabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DirectRabbitConfig
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/26 16:54
 * @Version 1.0
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directRabbitQueue() {
        return  new Queue("directRabbitQueue",true);
    }
    @Bean
    public DirectExchange directExchange() {
        return  new DirectExchange("directRabbitExchange");
    }
    @Bean
    public Binding testDirectRabbitBinding(Queue directRabbitQueue,DirectExchange directExchange) {
        return BindingBuilder.bind(directRabbitQueue).to(directExchange).with("TestDirectRouting");
    }
}
