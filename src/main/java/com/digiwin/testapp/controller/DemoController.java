package com.digiwin.testapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * FileName:DemoController
 * Author: shenbao
 * Date: 2022/5/16 13:48
 * Description:
 */
@RestController
public class DemoController {
    @RequestMapping("/demo")
    public String demo(HttpServletResponse response) {
        //测试302重定向
        response.setStatus(302);
        response.addHeader("Location", "https://graph.qq.com/oauth2.0/authorize?scope=get_user_info&state=a5tLWNR3Dio%2523movie%2523https%253A%2F%2Fmovie.douban.com%2F&redirect_uri=https%3A%2F%2Faccounts.douban.com%2Fconnect%2Fqq%2Fcallback&response_type=code&client_id=100387276");
        System.out.println("demo");
        return "demo";
    }
}
