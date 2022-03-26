package com.digiwin.testapp.design.prototype;

/**
 * FileName:PrototypeDemo
 * Author: shenbao
 * Date: 2022/3/26 20:44
 * Description:
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        ProtoTypeCache.loadData();
        ProtoTypeObject li = (ProtoTypeObject) ProtoTypeCache.getProtoTypeObject("li");
        li.setAge(40);
        //由于重新了clone，bytes会被clone，修改值之后，原有的对象值不变
        li.getBytes()[0] = 9;
        System.out.println(li);
    }
}
