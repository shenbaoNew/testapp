package com.digiwin.testapp.config;

import com.digiwin.testapp.filter.OpenApiFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * FileName:AppFilterConfiguration
 * Author: shenbao
 * Date: 2022/3/16 22:10
 * Description:
 */
@Configuration
public class AppFilterConfiguration {
    @Autowired
    ApplicationContext context;

    @Bean
    public OpenApiFilter2 openApiFilter2() {
        return new OpenApiFilter2();
    }

    @Bean
    public FilterRegistrationBean<OpenApiFilter2> filter2FilterRegistrationBean() {
        FilterRegistrationBean<OpenApiFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(context.getBean(OpenApiFilter2.class));
        filterRegistrationBean.addUrlPatterns(new String[]{"/eai"});
        filterRegistrationBean.setOrder(900002);
        return filterRegistrationBean;
    }
}
