package com.digiwin.testapp.design.prototype;

/**
 * FileName:ProtoTypeObject
 * Author: shenbao
 * Date: 2022/3/26 20:33
 * Description:原型模式，要实现Cloneable，重写clone(public)
 * 并且要复制该类本身的应用类型变量
 */
public class ProtoTypeObject implements Cloneable {
    private int age;
    private String name;
    private byte[] bytes = new byte[]{10, 39, 22};

    public ProtoTypeObject(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public ProtoTypeObject() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ProtoTypeObject clone = (ProtoTypeObject) super.clone();
        //内部的引用类型字段，要重新clone
        //重写clone()方法，一般会先调用super.clone()进行浅复制
        //然后再复制那些易变对象，从而达到深复制的效果
        clone.bytes = this.bytes.clone();
        return clone;
    }
}
