package com.digiwin.testapp.controller;

import com.digiwin.testapp.mq.publisher.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:MqController
 * Author: shenbao
 * Date: 2021/12/26 17:06
 * Description:
 */
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private MqService mqService;

    @RequestMapping("/send")
    public void sendMessage() {
        //消息会被发送到queueDemo，且只会被一个消费者消费
        mqService.sendMsg("hello,beijing,direct");
    }

    @RequestMapping("/sendtopic")
    public void sendTopicMessage() {
        //消息会同时发送到topicQueueDemo1和topicQueueDemo2(因为topicQueueDemo2关心topic.#,与本次tag==>topic.demo1匹配)
        mqService.sendTopicMsg("hello,beijing,topic", "topic.demo1");
        //消息只会被发送到topicQueueDemo2
        mqService.sendTopicMsg("hello,beijing,topic", "topic.demo2");
    }

    @RequestMapping("/sendfanout")
    public void sendFanoutMessage() {
        //消息会发送给所有绑定到fanoutExchangeDemo的队列
        mqService.sendFanoutMsg("hello,beijing,fanout");
    }

    @RequestMapping("/noexchange")
    public void sendNoExchange() {
        //测试确认机制===>找不到交换机
        mqService.testNotFindExchange("hello,beijing,not exists exchange");
    }

    @RequestMapping("/noqueue")
    public void sendNoQueue() {
        //测试确认机制===>找到交换机,但找不到队列
        mqService.testNotFindQueue("hello,beijing,not exists queue");
    }

    @RequestMapping("/manualack")
    public void sendManualAckMessage() {
        //测试确认机制===>找到交换机,但找不到队列
        mqService.sendManualAckMsg("hello beijing manual ack queue");
    }
}
