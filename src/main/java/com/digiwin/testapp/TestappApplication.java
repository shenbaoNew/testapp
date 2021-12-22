package com.digiwin.testapp;

import com.digiwin.testapp.context.SpringBeanUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestappApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestappApplication.class, args);
        SpringBeanUtils.setContext(context);
        BasicDataSource bean = context.getBean(BasicDataSource.class);
    }
}
