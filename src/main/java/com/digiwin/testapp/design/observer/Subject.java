package com.digiwin.testapp.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName:Subject
 * Author: shenbao
 * Date: 2022/3/26 23:46
 * Description:
 */
public class Subject {
    private String msg;
    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.notifyAllObserver(msg);
    }

    public void notifyAllObserver(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}
