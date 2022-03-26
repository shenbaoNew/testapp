package com.digiwin.testapp.design.single;

/**
 * FileName:SingleObject
 * Author: shenbao
 * Date: 2022/3/26 18:07
 * Description:懒汉式-线程不安全
 */
public class SingleObject2 {
    private static SingleObject2 singleObject;

    private SingleObject2() {

    }

    public static SingleObject2 getInstance() {
        if (singleObject == null) {
            singleObject = new SingleObject2();
        }
        return singleObject;
    }
}
