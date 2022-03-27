package com.digiwin.testapp.task.thread;

import java.io.IOException;

/**
 * FileName:Demo
 * Author: shenbao
 * Date: 2022/3/27 23:49
 * Description:
 */
public class Demo {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread1("thread1",obj).start();
        new Thread2("thread2",obj).start();

    }
}
