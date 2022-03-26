package com.digiwin.testapp.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * FileName:SaveInvocationHandler
 * Author: shenbao
 * Date: 2022/3/26 23:12
 * Description:
 */
public class SaveInvocationHandler implements InvocationHandler {
    private Object target;

    public SaveInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start...");
        Object invoke = method.invoke(target, args);
        System.out.println("proxy end...");
        return invoke;
    }
}
