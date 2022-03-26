package com.digiwin.testapp.design.factory;

/**
 * FileName:ShapeDemo
 * Author: shenbao
 * Date: 2022/3/26 17:16
 * Description:
 */
public class ShapeDemo {
    public static void main(String[] args) {
        Shape shape = (Shape) ShapeFactory.getShape(Circle.class);
        shape.draw();
        shape = (Shape) ShapeFactory.getShape(Rectangle.class);
        shape.draw();
    }
}
