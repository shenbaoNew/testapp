package com.digiwin.testapp.design.decorator;

/**
 * FileName:Decorator
 * Author: shenbao
 * Date: 2022/3/26 22:21
 * Description:
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        ICreateDocService docService = new CreateDocService();
        docService.create("销售订单");

        //功能增强
        ICreateDocService createDocService = new CreateDocDecorator(docService);
        createDocService.create("销售订单");
    }
}
