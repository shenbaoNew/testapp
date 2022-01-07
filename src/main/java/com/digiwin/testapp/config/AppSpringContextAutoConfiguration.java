package com.digiwin.testapp.config;

import com.digiwin.testapp.context.AppSpringContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FileName:AppContextUtils
 * Author: shenbao
 * Date: 2022/1/6 22:01
 * Description:
 */
@Configuration
public class AppSpringContextAutoConfiguration {
    @Bean
    public AppSpringContext appSpringContext() {
        //会执行AppSpringContext.setApplicationContext,注入上下文
        //1.需要定义一个bean
        //2.需要实现ApplicationContextAware
        return new AppSpringContext();
    }
}
