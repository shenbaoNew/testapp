package com.digiwin.testapp.service.impl;

import com.digiwin.testapp.annotation.AppService;
import com.digiwin.testapp.model.Parameter;
import com.digiwin.testapp.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * FileName:TestService
 * Author: shenbao
 * Date: 2021/12/22 14:53
 * Description:
 */
@Service("test")
public class TestService implements ITestService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @AppService(id = "test", callback = "test.callback", desc = {"service", "callback"})
    @Override
    public void test() {
        redisTemplate.opsForValue().set("app.test", "2020");
        redisTemplate.opsForHash().put("app.user", "name", "haixin");
        redisTemplate.opsForHash().put("app.user", "price", 2000);
        Parameter parameter = new Parameter();
        parameter.setPlanNo("202001001");
        redisTemplate.opsForValue().set("app.data", parameter);

        System.out.println(redisTemplate.opsForValue().get("app.test"));
        System.out.println(redisTemplate.opsForHash().get("app.user", "name"));
        System.out.println(redisTemplate.opsForValue().get("app.data"));
    }
}
