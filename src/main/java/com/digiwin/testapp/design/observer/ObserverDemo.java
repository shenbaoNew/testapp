package com.digiwin.testapp.design.observer;

/**
 * FileName:ObserverDemo
 * Author: shenbao
 * Date: 2022/3/26 23:50
 * Description:
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        FileObserver fileObserver = new FileObserver();
        subject.add(fileObserver);

        ConsoleObserver consoleObserver = new ConsoleObserver();
        subject.add(consoleObserver);
        subject.setMsg("abc");
    }
}
