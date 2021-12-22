package com.digiwin.testapp.controller;

import com.digiwin.testapp.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:TestController
 * Author: shenbao
 * Date: 2021/12/22 15:03
 * Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService testService;

    @RequestMapping("/a")
    public void test(){
        testService.test();
    }
}
