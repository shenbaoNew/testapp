package com.digiwin.testapp.design.factory;

import com.digiwin.testapp.design.model.ShapeType;

/**
 * FileName:ShapeFactory
 * Author: shenbao
 * Date: 2022/3/26 17:14
 * Description:
 */
public class ShapeFactory {
    public static Shape getShape(Class<? extends Shape> shapeClass) {
        Shape shape = null;
        try {
            shape = shapeClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return shape;
    }

    public static Shape getShape(ShapeType type) {
        switch (type) {
            case Circle:
                return new Circle();
            case Rectangle:
                return new Rectangle();
            default:
                return null;
        }
    }
}
