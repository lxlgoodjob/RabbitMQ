package com.example.provider.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : lxl
 * @CreateTime : 2022/01/03
 * @Description :主题型交换机
 **/
@Configuration
public class TopicConfig {

    @Bean
    public Queue TopicQueueMan() {
        return new Queue("TopicQueueMan");
    }

    @Bean
    public Queue TopicQueueWoman() {
        return new Queue("TopicQueueWoman");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("TopicExchange");
    }

    @Bean
    Binding bindingTopic() {
        return BindingBuilder.bind(TopicQueueMan()).to(exchange()).with("man");
    }

    @Bean
    Binding bindingTopic2() {
        return BindingBuilder.bind(TopicQueueWoman()).to(exchange()).with("woman");
    }
}
