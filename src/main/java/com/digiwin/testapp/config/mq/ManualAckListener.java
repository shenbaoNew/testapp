package com.digiwin.testapp.config.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName:ManualAckListener
 * Author: shenbao
 * Date: 2021/12/26 22:42
 * Description:
 */
@Component
public class ManualAckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(message.getBody());
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
            Map<String,Object> msgMap = (Map<String,Object>)inputStream.readObject();
            Object messageId = msgMap.get("uid");
            Object messageData = msgMap.get("msg");
            Object createTime = msgMap.get("time");
            //发送与消费的速率对比
            Thread.sleep(5000);
            System.out.println(new Date() + "ManualAckListener  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
            System.out.println("消费的主题消息来自：" + message.getMessageProperties().getConsumerQueue());
            channel.basicAck(deliveryTag, true); //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            //channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
        } catch (Exception ex) {
            channel.basicReject(deliveryTag, false);
            ex.printStackTrace();
        }
    }

    private Map<String, String> mapStringToMap(String str, int entryNum) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",", entryNum);
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
}
