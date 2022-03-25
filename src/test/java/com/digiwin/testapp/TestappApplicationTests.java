package com.digiwin.testapp;

import com.digiwin.testapp.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

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
        try {
            System.out.println(client.getConfig().toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reentrantLock() {
        //可重入锁
        RLock lock = client.getLock("lock1");
        try {
            lock.lock();
            try {
                System.out.println("lock1 start ...");
                Thread.sleep(3000);
                System.out.println("lock1 end ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
