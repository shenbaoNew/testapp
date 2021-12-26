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
        mqService.sendMsg("hello,beijing");
    }
}
