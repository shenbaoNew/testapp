package com.digiwin.testapp.design;

import com.digiwin.testapp.TestappApplication;
import com.digiwin.testapp.design.prototype.ProtoTypeCache;
import com.digiwin.testapp.design.prototype.ProtoTypeObject;
import com.digiwin.testapp.design.single.SingleObject5;

import java.io.File;
import java.net.URL;

/**
 * FileName:OtherDemo
 * Author: shenbao
 * Date: 2022/3/26 18:20
 * Description:
 */
public class OtherDemo {
    public static void main(String[] args) {
        String packageName = "com.digiwin.testapp.design.proxy";
        URL resource = TestappApplication.class.getClassLoader().getResource(packageName.replace(".", "/"));
        System.out.println(resource);
        File file = new File(resource.getFile());
        System.out.println(file.isDirectory());
        for (int i = 0; i < file.listFiles().length; i++) {
        }
    }
}
