package com.digiwin.testapp;

import com.digiwin.testapp.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.digiwin.testapp.TestappApplication.class})
public class TestappApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    RedissonClient client;

    @Autowired
    TestService testService;

    @Test
    public void abc() {
        System.out.println(client);
        System.out.println(testService);
    }
}
