package com.digiwin.testapp.design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * FileName:PrinterProxy
 * Author: shenbao
 * Date: 2022/3/26 23:19
 * Description:
 */
public class PrinterProxy implements MethodInterceptor {
    private Object target;

    public PrinterProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy start...");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib proxy end...");
        return invoke;
    }

    public static Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new PrinterProxy(target));
        return enhancer.create();
    }
}
