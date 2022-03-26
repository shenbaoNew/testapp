package com.digiwin.testapp.design.single;

/**
 * FileName:SingleObject
 * Author: shenbao
 * Date: 2022/3/26 18:07
 * Description:饿汉式
 * 导致类加载的因素很多（并不是只有getInstance，所以一定程度上没有达到laze loadding）
 */
public class SingleObject {
    private static SingleObject singleObject = new SingleObject();

    private SingleObject() {

    }

    public static SingleObject getInstance() {
        return singleObject;
    }
}
