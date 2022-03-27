package com.digiwin.testapp.task.thread;

/**
 * FileName:Thread1
 * Author: shenbao
 * Date: 2022/3/27 23:44
 * Description:
 */
public class Thread1 extends Thread {
    private String name;
    private Object syncObject;

    public Thread1(String name, Object syncObject) {
        this.name = name;
        this.syncObject = syncObject;
    }

    @Override
    public void run() {
        synchronized (this.syncObject) {
            System.out.println(name + " start...");
            try {
                this.syncObject.wait();
                Thread.sleep(1000);
                System.out.println(name + " end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
