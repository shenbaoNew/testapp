package com.digiwin.testapp.controller;

import com.digiwin.testapp.model.User;
import com.digiwin.testapp.service.ITestService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * FileName:TestController
 * Author: shenbao
 * Date: 2021/12/22 15:03
 * Description:
 */
@RestController
@Validated
//@RequestMapping("/eai")
public class TestController {
    @Autowired
    private ITestService testService;

    @Autowired
    RedissonClient client;

    @RequestMapping("/eai")
    public void test() {
        testService.test();
    }

    @RequestMapping("/lock1")
    public String lock1() {
        //可重入锁
        RLock lock = client.getLock("lock1");
        try {
            lock.lock();
            try {
                System.out.println(formatDate() + ":lock1 start ...");
                Thread.sleep(5000);
                System.out.println(formatDate() + ":lock1 end ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
        return formatDate();
    }

    @RequestMapping("/lock2")
    public String lock2() {
        //可重入锁
        RLock lock = client.getLock("lock1");
        try {
            lock.lock(3, TimeUnit.SECONDS);
            try {
                System.out.println(formatDate() + ":lock1 start ...");
                Thread.sleep(5000);
                System.out.println(formatDate() + ":lock1 end ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println(formatDate() + ":unlock");
            }
        }
        return formatDate();
    }

    @RequestMapping("/test3")
    public String test3(@NotNull(message = "用户不可为空") User user) {
        User user1 = new User(user.getCode(), user.getName());
        return user1.getName();
    }

    private String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
