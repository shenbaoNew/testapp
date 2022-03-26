package com.digiwin.testapp.design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName:ProtoTypeCache
 * Author: shenbao
 * Date: 2022/3/26 20:37
 * Description:
 */
public class ProtoTypeCache {
    public static Map<String, ProtoTypeObject> typeCacheMap = new HashMap<>();

    public static Object getProtoTypeObject(String name) {
        Object clone = null;
        try {
            clone = typeCacheMap.get(name).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public static void loadData() {
        ProtoTypeObject protoTypeObject = new ProtoTypeObject(20, "shen");
        typeCacheMap.put(protoTypeObject.getName(), protoTypeObject);
        protoTypeObject = new ProtoTypeObject(30, "li");
        typeCacheMap.put(protoTypeObject.getName(), protoTypeObject);
    }
}
