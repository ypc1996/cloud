package com.example.provider.listener;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yangpengcheng
 * @ClassName MessageListener
 * @Description:
 * @date 2020/11/1214:15
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "logs"),exchange = @Exchange(value = "logs",type = "direct"),key = {"info"}))
public class MessageListener {

    @RabbitHandler
    public void handle(String message){
        System.out.println(message);
    }


}
