package com.digiwin.testapp.task.thread;

/**
 * FileName:Thread1
 * Author: shenbao
 * Date: 2022/3/27 23:44
 * Description:
 */
public class Thread2 extends Thread {
    private String name;
    private Object syncObject;

    public Thread2(String name, Object syncObject) {
        this.name = name;
        this.syncObject = syncObject;
    }

    @Override
    public void run() {
        synchronized (this.syncObject) {
            //this.syncObject.notify();
            System.out.println(name + " start...");
            try {
                Thread.sleep(3000);
                System.out.println(name + " end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
