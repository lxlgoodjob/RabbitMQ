package com.example.provider.Controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : lxl
 * @CreateTime : 2022/01/03
 * @Description :生产者控制器
 **/
@RestController
@RequestMapping("/provier")
public class ProvierController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/directMessage")
    public String DirectMessage(String message){
        //将消息绑定到交换机和匹配健上
        rabbitTemplate.convertAndSend("DirectExchange","DirectRouting",message);
        return "直连交换机推送消息完成";
    }

    @PostMapping("/fanoutMessage")
    public String fanoutMessage(String message){
        //将消息绑定到扇形交换机上
        rabbitTemplate.convertAndSend("FanoutExchange",null,message);
        return "扇形交换机推送消息完成";
    }

    @PostMapping("/topicMessage")
    public String topicMessage(String message, String topic){
        //将消息绑定到主题交换机上
        rabbitTemplate.convertAndSend("TopicExchange",topic,message);
        return "推送"+topic+"主题消息完成";
    }

    @PostMapping("/onfirmCallback")
    public String onfirmCallback(String message){
        //测试ConfirmCallback失败响应，没有该交换机
        rabbitTemplate.convertAndSend("unExchange",null,message);
        return "推送消息完成";
    }

    @PostMapping("/returnsCallback")
    public String returnsCallback(String message){
        //测试returnsCallback失败响应，没有绑定队列
        rabbitTemplate.convertAndSend("NoQueueDirectExchange","null",message);
        return "推送消息完成";
    }
}
