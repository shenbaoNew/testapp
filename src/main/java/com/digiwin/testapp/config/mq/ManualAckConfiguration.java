package com.digiwin.testapp.config.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FileName:ManualAckConfiguration
 * Author: shenbao
 * Date: 2021/12/26 22:48
 * Description:
 */
@Configuration
public class ManualAckConfiguration {
    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    ManualAckListener manualAckListener;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(cachingConnectionFactory);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);// RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        simpleMessageListenerContainer.setQueueNames("manualConfirmQueueDemo");

        simpleMessageListenerContainer.setMessageListener(manualAckListener);
        return simpleMessageListenerContainer;
    }
}
