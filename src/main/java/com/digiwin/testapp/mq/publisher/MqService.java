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
        Map<String, Object> sendMsg = getMsg(msg);
        rabbitTemplate.convertAndSend("directExchangeDemo", "demo_router_key", sendMsg);
    }

    @Override
    public void sendTopicMsg(String msg, String routerKey) {
        Map<String, Object> sendMsg = getMsg(msg);
        rabbitTemplate.convertAndSend("topicExchangeDemo", routerKey, sendMsg);
    }

    @Override
    public void sendFanoutMsg(String msg) {
        Map<String, Object> sendMsg = getMsg(msg);
        //fanout类型exchange不需要给routerkey，给了也不起作用
        rabbitTemplate.convertAndSend("fanoutExchangeDemo", null, sendMsg);
    }

    @Override
    public void testNotFindExchange(String msg) {
        Map<String, Object> sendMsg = getMsg(msg);
        rabbitTemplate.convertAndSend("noexistsdirectExchangeDemo", "demo_router_key", sendMsg);
    }

    @Override
    public void testNotFindQueue(String msg) {
        Map<String, Object> sendMsg = getMsg(msg);
        rabbitTemplate.convertAndSend("directExchangeDemo", "demo_router_key_not_find", sendMsg);
    }

    @Override
    public void sendManualAckMsg(String msg) {
        Map<String, Object> sendMsg = getMsg(msg);
        rabbitTemplate.convertAndSend("directExchangeDemo", "direct.manual.demo", sendMsg);
    }

    public Map getMsg(String msg) {
        Map<String, Object> sendMsg = new HashMap<>();
        sendMsg.put("msg", msg);
        sendMsg.put("user", "admin");
        sendMsg.put("time", new Date());
        sendMsg.put("uid", String.valueOf(UUID.randomUUID()));
        return sendMsg;
    }
}
