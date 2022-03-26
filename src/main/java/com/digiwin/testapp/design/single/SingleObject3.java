package com.digiwin.testapp.design.single;

/**
 * FileName:SingleObject
 * Author: shenbao
 * Date: 2022/3/26 18:07
 * Description:懒汉式-线程安全（synchronize会影响效率）
 */
public class SingleObject3 {
    private static SingleObject3 singleObject;

    private SingleObject3() {

    }

    public synchronized static SingleObject3 getInstance() {
        if (singleObject == null) {
            singleObject = new SingleObject3();
        }
        return singleObject;
    }
}
