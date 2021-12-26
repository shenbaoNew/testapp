package com.digiwin.testapp.mq.publisher;

import com.digiwin.testapp.config.AppRabbitMqAutoConfiguration;
import com.digiwin.testapp.mq.publisher.IMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * FileName:MqService
 * Author: shenbao
 * Date: 2021/12/26 17:07
 * Description:
 */
@Service
public class MqService implements IMqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String msg) {
        Map<String, Object> sendMsg = new HashMap<>();
        sendMsg.put("msg", msg);
        sendMsg.put("user", "admin");
        sendMsg.put("time", new Date());
        sendMsg.put("uid", String.valueOf(UUID.randomUUID()));
        rabbitTemplate.convertAndSend("directExchangeDemo", "demo_router_key", sendMsg);
    }

    @Override
    public void sendTopicMsg(String msg, String routerKey) {
        Map<String, Object> sendMsg = new HashMap<>();
        sendMsg.put("msg", msg);
        sendMsg.put("user", "admin");
        sendMsg.put("time", new Date());
        sendMsg.put("uid", String.valueOf(UUID.randomUUID()));
        rabbitTemplate.convertAndSend("topicExchangeDemo", routerKey, sendMsg);
    }
}
