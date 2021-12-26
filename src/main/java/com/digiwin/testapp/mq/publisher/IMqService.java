package com.digiwin.testapp.mq.publisher;

/**
 * FileName:IMqService
 * Author: shenbao
 * Date: 2021/12/26 17:07
 * Description:
 */
public interface IMqService {
    void sendMsg(String msg);

    void sendTopicMsg(String msg,String routerKey);
}
