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
    @ApiInvoker(callerName = "calculate.material.requirements.process", serviceName = "item.supply.demand.data.get")
    public void test1() {
        try {
            //获取方法上面的注解
            Method test1 = this.getClass().getMethod("test1");
            MulApiInvoker mulApiInvoker = test1.getAnnotation(MulApiInvoker.class);
            for (ApiInvoker invoker : mulApiInvoker.value()) {
                System.out.println("caller:" + invoker.callerName() + " service:" + invoker.serviceName());
            }

            //获取接口方法上面的注解
            ITestService service = new TestService();
            for (Class<?> anInterface : service.getClass().getInterfaces()) {
                for (Method method : anInterface.getMethods()) {
                    //这里用MulApiInvoker.class，不要用对象.getClass，否则获取不到注解
                    MulApiInvoker mulApiInvoker1 = method.getDeclaredAnnotation(MulApiInvoker.class);
                    for (ApiInvoker invoker : mulApiInvoker1.value()) {
                        System.out.println("caller:" + invoker.callerName() + " service:" + invoker.serviceName());
                    }
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
