package com.digiwin.testapp.config;

import com.digiwin.testapp.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FileName:AppTestAutoConfiguration
 * Author: shenbao
 * Date: 2021/12/27 22:21
 * Description:
 */
@Configuration
public class AppTestAutoConfiguration {
    @Bean("user01")
    public User user(){
        return new User("001","shen");
    }
}
