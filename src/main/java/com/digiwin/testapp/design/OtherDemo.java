package com.digiwin.testapp.design;

import com.digiwin.testapp.TestappApplication;
import com.digiwin.testapp.design.prototype.ProtoTypeCache;
import com.digiwin.testapp.design.prototype.ProtoTypeObject;
import com.digiwin.testapp.design.single.SingleObject5;

import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName:OtherDemo
 * Author: shenbao
 * Date: 2022/3/26 18:20
 * Description:
 */
public class OtherDemo {
    public static void main(String[] args) {
        //String packageName = "com.digiwin.testapp.design.proxy";
        //URL resource = TestappApplication.class.getClassLoader().getResource(packageName.replace(".", "/"));
        //System.out.println(resource);
        //File file = new File(resource.getFile());
        //System.out.println(file.isDirectory());
        //for (int i = 0; i < file.listFiles().length; i++) {
        //}

        Long v = 374697956856384L;
        BigInteger b = BigInteger.valueOf(v);
        System.out.println(v.hashCode());
        System.out.println(b.hashCode());

        Map<Object,Object> map = new HashMap<>();
        map.put(v,"11");
        System.out.println(map.get(BigInteger.valueOf(v)));
        System.out.println(map.get(v));

        v = 37469795685638L;
        map.put(v,"22");
        System.out.println(map.get(BigInteger.valueOf(v)));
        System.out.println(map.get(v));

        v = 10L;
        map.put(v,"33");
        System.out.println(map.get(BigInteger.valueOf(v)));
        System.out.println(map.get(v));
    }
}
