package com.digiwin.testapp;

import com.digiwin.testapp.annotation.AppService;
import com.digiwin.testapp.config.AppTestAutoConfiguration;
import com.digiwin.testapp.model.User;
import com.digiwin.testapp.service.ITestService;
import com.digiwin.testapp.service.dap.ApiInvokerTest;
import com.digiwin.testapp.service.dap.RestTest;
import com.digiwin.testapp.service.impl.TestService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

@SpringBootApplication
public class TestappApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestappApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }

        User user = context.getBean("user01", User.class);
        User user1 = context.getBean("user01", User.class);
        System.out.println(user == user1);

        AppTestAutoConfiguration appTestAutoConfiguration = context.getBean(AppTestAutoConfiguration.class);
        User user2 = appTestAutoConfiguration.user();
        User user3 = appTestAutoConfiguration.user();
        System.out.println(user2 == user3);

        ITestService testService = context.getBean(ITestService.class);
        try {
            Method test = testService.getClass().getMethod("test");
            boolean annotationPresent = test.isAnnotationPresent(AppService.class);
            if (annotationPresent) {
                AppService annotation = test.getAnnotation(AppService.class);
                System.out.println("id=" + annotation.id() + " callback=" + annotation.callback() + " desc=" + annotation.desc().toString());
            }
            test();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        //ApiInvokerTest apiInvokerTest = new ApiInvokerTest();
        //apiInvokerTest.test1();
        //RestTest restTest = new RestTest();
        //restTest.test();
        Object obj = null;
        Assert.notNull(obj,"obj mast not be null ");
    }
}
