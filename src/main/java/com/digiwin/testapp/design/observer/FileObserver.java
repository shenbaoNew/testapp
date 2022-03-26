package com.digiwin.testapp.design.observer;

/**
 * FileName:FileObserver
 * Author: shenbao
 * Date: 2022/3/26 23:47
 * Description:
 */
public class FileObserver extends Observer {
    @Override
    public void update(String msg) {
        System.out.println("写入文件：" + msg);
    }
}
