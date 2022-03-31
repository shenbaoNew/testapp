package com.digiwin.testapp;

import com.digiwin.testapp.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestappApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    RedissonClient client;

    @Autowired
    TestService testService;

    //@Test
    public void abc() {
        try {
            System.out.println(client.getConfig().toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Test
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

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void token_password() {
        //https://www.cnblogs.com/LOVE0612/p/9913336.html
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", "admin");
        params.add("password", "admin");
        params.add("scope", "scope1 scope2");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_client() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_code() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("code", "KQ9rAR");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_refresh() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", "fb00358a-44e2-4679-9129-1b96f52d8d5d");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }
}
