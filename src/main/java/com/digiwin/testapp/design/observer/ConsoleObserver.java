package com.digiwin.testapp.design.observer;

/**
 * FileName:ConsoleObserver
 * Author: shenbao
 * Date: 2022/3/26 23:47
 * Description:
 */
public class ConsoleObserver extends Observer {
    @Override
    public void update(String msg) {
        System.out.println("写入控制台：" + msg);
    }
}
