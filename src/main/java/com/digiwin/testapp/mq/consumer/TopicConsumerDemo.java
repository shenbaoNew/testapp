package com.digiwin.testapp.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * FileName:MqConsumerDemo
 * Author: shenbao
 * Date: 2021/12/26 17:24
 * Description:
 */
@Component
@RabbitListener(queues = {"topicQueueDemo1"})
public class TopicConsumerDemo {
    @RabbitHandler
    public void process(Map msg) {
        System.out.println("topic consumer1 收到消息：" + msg);
    }
}
