package com.digiwin.testapp.design.single;

import com.digiwin.testapp.design.Other;

/**
 * FileName:SingleObject
 * Author: shenbao
 * Date: 2022/3/26 18:07
 * Description:登记式/静态内部类(效率高)
 * 如果并不因为调用getInstance导致的SingleObject类被加载，就不会初始化SingleObject5对象
 * 只有在访问getInstance才会真正产生SingleObject5对象（这才是真正的laze loading），避免浪费内存
 */
public class SingleObject5 {
    private SingleObject5() {

    }

    public static SingleObject5 getInstance() {
        return SingleObjectHolder.INSTANCE;
    }

    private static class SingleObjectHolder {
        private final static SingleObject5 INSTANCE = new SingleObject5();
    }
}
