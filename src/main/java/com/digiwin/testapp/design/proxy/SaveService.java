package com.digiwin.testapp.design.proxy;

/**
 * FileName:SaveService
 * Author: shenbao
 * Date: 2022/3/26 23:11
 * Description:
 */
public class SaveService implements ISaveService {
    @Override
    public void save(Object data) {
        System.out.println("save data...");
    }
}
