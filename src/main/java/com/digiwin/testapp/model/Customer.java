package com.digiwin.testapp.model;

import com.digiwin.testapp.service.IDemoService;
import com.digiwin.testapp.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FileName:Customer
 * Author: shenbao
 * Date: 2022/5/15 20:47
 * Description:
 */
public class Customer {
    @Autowired
    private IDemoService demoService;

    private ITestService testService;

    public IDemoService getDemoService() {
        return demoService;
    }

    public void getName(){
        System.out.println("customer");
    }
}
