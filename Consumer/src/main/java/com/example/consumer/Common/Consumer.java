package com.example.consumer.Common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author : lxl
 * @CreateTime : 2022/01/03
 * @Description :消费者消费方法
 **/
@Component
public class Consumer {

    //消费直连交换机消息
    @RabbitListener(queues = "DirectQueue")
    public void getDirectMessage(String message) {
        System.out.println(message);
    }

    //消费扇形交换机消息
    @RabbitListener(queues = {"FanoutQueue1","FanoutQueue2"})
    public void getFanoutMessage12(String message) {
        System.out.println("FanoutQueue1和FanoutQueue2队列消息："+message);
    }

    //消费扇形交换机消息
    @RabbitListener(queues = "FanoutQueue3")
    public void getFanoutMessage3(String message) {
        System.out.println("FanoutQueue3队列消息"+message);
    }

    //消费主题交换机消息Man
    @RabbitListener(queues = "TopicQueueMan")
    public void getTopicMessage1(String message) {
        System.out.println("TopicQueueMan队列消息"+message);
    }

    //消费主题交换机消息Wonan
    @RabbitListener(queues = "TopicQueueWoman")
    public void getTopicMessage2(String message) {
        System.out.println("TopicQueueWoMan队列消息"+message);
    }
}

