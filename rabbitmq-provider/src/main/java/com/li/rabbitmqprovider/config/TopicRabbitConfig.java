package com.li.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Name;

/**
 * @ClassName TopicRabbitConfig
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 8:49
 * @Version 1.0
 */
@Configuration
public class TopicRabbitConfig{

    private final static String man="topic.man";
    private final static String woman="topic.woman";

    @Bean("queue")
    public Queue queue(){
        return new Queue(TopicRabbitConfig.man);
    }
    @Bean("queue1")
    public Queue queue1(){
        return new Queue(TopicRabbitConfig.woman);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    public Binding binding(@Autowired @Qualifier("queue") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(TopicRabbitConfig.man);
    }
    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    public Binding binding1( @Autowired @Qualifier("queue1") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.#");
    }

}
