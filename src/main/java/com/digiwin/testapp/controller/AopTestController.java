package com.digiwin.testapp.controller;

import com.digiwin.testapp.aop.LogTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:AopTestController
 * Author: shenbao
 * Date: 2022/5/15 15:45
 * Description:
 *
 * @author mi
 */
@RestController
public class AopTestController {
    @Autowired
    private LogTester jdkLogTester;

    @GetMapping("/test1")
    public void test1(String msg) {
        jdkLogTester.debug(msg);
    }
}
