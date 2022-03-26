package com.digiwin.testapp.design.proxy;

import java.lang.reflect.Proxy;

/**
 * FileName:ProxyDemo
 * Author: shenbao
 * Date: 2022/3/26 23:14
 * Description:
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ISaveService saveService = new SaveService();
        saveService.save("data");
        SaveInvocationHandler saveInvocationHandler = new SaveInvocationHandler(saveService);
        //jdk动态代理
        ISaveService proxy = (ISaveService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                , new Class[]{ISaveService.class}, saveInvocationHandler);
        proxy.save("data");

        //cglib动态代理
        Printer printer = (Printer) PrinterProxy.getProxy(new Printer());
        printer.print("xxx.java");
    }
}
