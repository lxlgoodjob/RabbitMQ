package com.example.provider.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : lxl
 * @CreateTime : 2022/01/03
 * @Description :扇形交换机
 **/
@Configuration
public class FanoutConfig {

    //创建3个队列，绑定到一个扇形交换机上
    @Bean
    public Queue queue1() {
        return new Queue("FanoutQueue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("FanoutQueue2");
    }

    @Bean
    public Queue queue3() {
        return new Queue("FanoutQueue3");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange");
    }

    @Bean
    Binding bindingFanout1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    Binding bindingFanout3() {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }
}
