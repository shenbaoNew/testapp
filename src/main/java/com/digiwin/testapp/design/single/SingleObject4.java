package com.digiwin.testapp.design.single;

/**
 * FileName:SingleObject
 * Author: shenbao
 * Date: 2022/3/26 18:07
 * Description:双重校验锁(效率高)
 */
public class SingleObject4 {
    private static SingleObject4 singleObject;

    private SingleObject4() {

    }

    public static SingleObject4 getInstance() {
        if (singleObject == null) {
            synchronized (SingleObject4.class) {
                if (singleObject == null) {
                    singleObject = new SingleObject4();
                }
            }
        }
        return singleObject;
    }
}
