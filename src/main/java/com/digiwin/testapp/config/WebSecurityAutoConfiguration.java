package com.digiwin.testapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * FileName:WebSecurityAutoConfiguration
 * Author: shenbao
 * Date: 2022/3/30 21:12
 * Description:
 */
@Configuration
public class WebSecurityAutoConfiguration {
    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity httpSecurity) throws Exception {
                httpSecurity.formLogin().and().csrf().disable();

                //httpSecurity.csrf().disable()//禁用csrf （csrf会拦截所有post请求）
                //        .headers().frameOptions().disable()//允许使用iframe
                //        .and().authorizeRequests()
                //        .antMatchers("/home", "/register", "/socket").permitAll()//首页、注册、web socket，不需要权限
                //        .antMatchers("/static/**", "/ueditor/**", "/error/**").permitAll()
                //        .antMatchers("/oauth/**", "/api/**").permitAll()//当前filter不拦截 OAuth2.0 的路径
                //        .anyRequest().authenticated()
                //        .antMatchers("/admin/**").hasRole("admin")//预留管理员权限
                //        .and().formLogin().defaultSuccessUrl("/home").permitAll()
                //        .and().logout().logoutUrl("/login?logout").logoutSuccessUrl("/").permitAll();

            }
        };
    }
}
