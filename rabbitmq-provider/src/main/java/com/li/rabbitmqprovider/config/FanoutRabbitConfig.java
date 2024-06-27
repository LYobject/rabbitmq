package com.li.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutabbitConfig
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 9:56
 * @Version 1.0
 */
@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue QueueA() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue QueueB() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue QueueC() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange foamExchange() {
        return  new FanoutExchange("fanout.exchange");
    }

    @Bean
    public Binding BindingA(@Autowired @Qualifier("QueueA") Queue queue) {
        return BindingBuilder.bind(queue).to(foamExchange());
    }

    @Bean
    public Binding BindingB(@Autowired @Qualifier("QueueB") Queue queue) {
        return BindingBuilder.bind(queue).to(foamExchange());
    }
    @Bean
    public Binding BindingC(@Autowired @Qualifier("QueueC") Queue queue) {
        return BindingBuilder.bind(queue).to(foamExchange());
    }
}
