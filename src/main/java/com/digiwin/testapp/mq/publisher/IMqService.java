package com.digiwin.testapp.mq.publisher;

/**
 * FileName:IMqService
 * Author: shenbao
 * Date: 2021/12/26 17:07
 * Description:
 */
public interface IMqService {
    void sendMsg(String msg);

    void sendTopicMsg(String msg, String routerKey);

    void sendFanoutMsg(String msg);

    /**
     * 测试找不到交换机
     */
    void testNotFindExchange(String msg);

    /**
     * 测试找到了交换机，但是找不到队列
     * @param msg
     */
    void  testNotFindQueue(String msg);

    /**
     * 发送手工确认模式下的消息
     * @param msg
     */
    void sendManualAckMsg(String msg);
}
