package com.digiwin.testapp;

import com.digiwin.testapp.utils.AppCommonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class TestappApplicationTests {

    @Test
    void contextLoads() {
        Properties properties = AppCommonUtils.loadProperties("application.properties");
        System.out.println(properties);
        System.out.println(properties.getProperty("spring.datasource.driver-class-name"));
    }

}
