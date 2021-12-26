package com.digiwin.testapp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FileName:AppRabbitMqAutoConfiguration
 * Author: shenbao
 * Date: 2021/12/26 15:26
 * Description:
 */
@Configuration
public class AppRabbitMqAutoConfiguration {
    public final static String DIRECT_ROUTER_KEY = "demo_router_key";
    public final static String TOPIC_ROUTER_KEY1 = "topic.demo1";
    public final static String TOPIC_ROUTER_KEY2 = "topic.demo2";

    @Bean
    public DirectExchange directExchangeDemo() {
        //direct 类型交换器
        return new DirectExchange("directExchangeDemo", true, false);
    }

    @Bean
    public Queue directQueueDemo() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("queueDemo", true);
    }

    @Bean
    public Binding directBindingDemo() {
        //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
        return BindingBuilder.bind(directQueueDemo()).to(directExchangeDemo()).with(DIRECT_ROUTER_KEY);
    }

    @Bean
    public TopicExchange topicExchangeDemo() {
        //topic 类型交换器
        return new TopicExchange("topicExchangeDemo", true, false);
    }

    @Bean
    public Queue topicQueueDemo1() {
        return new Queue("topicQueueDemo1", true);
    }

    @Bean
    public Queue topicQueueDemo2() {
        return new Queue("topicQueueDemo2", true);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueueDemo1()).to(topicExchangeDemo()).with(TOPIC_ROUTER_KEY1);
    }

    @Bean
    public Binding topicBinding2() {
        //# 代表匹配一个或者多个单词 topic.test.demo
        //* 代表匹配一个单词 topic.test
        return BindingBuilder.bind(topicQueueDemo2()).to(topicExchangeDemo()).with("topic.#");
    }

    @Bean
    public FanoutExchange fanoutExchangeDemo() {
        //fanout 类型交换器  ==> 路由键无需配置,配置也不起作用
        return new FanoutExchange("fanoutExchangeDemo", true, false);
    }

    @Bean
    public Queue fanoutQueueDemo1() {
        return new Queue("fanoutQueueDemo1", true);
    }

    @Bean
    public Queue fanoutQueueDemo2() {
        //路由键无需配置
        return new Queue("fanoutQueueDemo2", true);
    }

    @Bean
    public Binding fanoutBinding1() {
        //路由键无需配置
        return BindingBuilder.bind(fanoutQueueDemo1()).to(fanoutExchangeDemo());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueueDemo2()).to(fanoutExchangeDemo());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:  相关数据:" + correlationData);
                System.out.println("ConfirmCallback:  确认情况:" + ack);
                System.out.println("ConfirmCallback:  原因:" + cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     " + "消息：" + message);
                System.out.println("ReturnCallback:     " + "回应码：" + replyCode);
                System.out.println("ReturnCallback:     " + "回应信息：" + replyText);
                System.out.println("ReturnCallback:     " + "交换机：" + exchange);
                System.out.println("ReturnCallback:     " + "路由键：" + routingKey);
            }
        });

        return rabbitTemplate;
    }
}
