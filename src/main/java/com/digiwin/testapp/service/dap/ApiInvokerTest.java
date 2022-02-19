package com.digiwin.testapp.service.dap;

import com.digiwin.testapp.annotation.ApiInvoker;
import com.digiwin.testapp.annotation.MulApiInvoker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * FileName:ApiInvokerTest
 * Author: shenbao
 * Date: 2022/2/19 21:37
 * Description:
 */
public class ApiInvokerTest {
    @ApiInvoker(callerName = "a.b.c", serviceName = "a1.b1.c1")
    @ApiInvoker(callerName = "m.n.q", serviceName = "m1.n1.q1")
    public void test1() {
        try {
            Method test1 = this.getClass().getMethod("test1");
            MulApiInvoker mulApiInvoker = test1.getAnnotation(MulApiInvoker.class);
            for (ApiInvoker invoker : mulApiInvoker.value()) {
                System.out.println("caller:" + invoker.callerName() + " service:" + invoker.serviceName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
