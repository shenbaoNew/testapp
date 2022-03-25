package com.digiwin.testapp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * FileName:AppRedisson
 * Author: shenbao
 * Date: 2022/3/25 22:03
 * Description:
 */
@Configuration
public class AppRedissonConfiguration {
    private static Log log = LogFactory.getLog(AppRedissonConfiguration.class);

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
