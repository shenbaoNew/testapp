package com.digiwin.testapp.design.decorator;

/**
 * FileName:CreateDocService
 * Author: shenbao
 * Date: 2022/3/26 22:19
 * Description:
 */
public class CreateDocService implements ICreateDocService {
    @Override
    public void create(String docName) {
        System.out.println("创建订单：" + docName);
    }
}
