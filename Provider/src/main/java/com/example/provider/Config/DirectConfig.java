package com.example.provider.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : lxl
 * @CreateTime : 2022/01/03
 * @Description :直连型交换机
 **/
@Configuration
public class DirectConfig {

    //创建队列
    @Bean
    public Queue DirectQueue() {
        return new Queue("DirectQueue");
    }

    //创建交换机
    @Bean
    DirectExchange DirectExchange() {
        return new DirectExchange("DirectExchange");
    }
    @Bean
    DirectExchange NoQueueDirectExchange() {
        return new DirectExchange("NoQueueDirectExchange");
    }

    //绑定队列和交换机, 并设置用于匹配键：DirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(DirectQueue()).to(DirectExchange()).with("DirectRouting");
    }

}
