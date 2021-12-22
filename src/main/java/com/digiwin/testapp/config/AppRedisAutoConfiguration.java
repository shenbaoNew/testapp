package com.digiwin.testapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * FileName:AppRedisAutoConfiguration
 * Author: shenbao
 * Date: 2021/12/22 14:58
 * Description:
 */
@Configuration
public class AppRedisAutoConfiguration {
    public AppRedisAutoConfiguration() {
    }

    @Bean()
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redis = new RedisTemplate<>();
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redis.setHashKeySerializer(new StringRedisSerializer());
        redis.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redis.setConnectionFactory(redisConnectionFactory);
        redis.afterPropertiesSet();
        return redis;
    }
}
