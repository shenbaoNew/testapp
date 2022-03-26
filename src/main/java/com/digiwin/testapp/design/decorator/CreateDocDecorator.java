package com.digiwin.testapp.design.decorator;

/**
 * FileName:CreateDocDecoretor
 * Author: shenbao
 * Date: 2022/3/26 22:19
 * Description:
 */
public class CreateDocDecorator implements ICreateDocService {
    ICreateDocService decorator;

    public CreateDocDecorator(ICreateDocService createDocService) {
        this.decorator = createDocService;
    }

    @Override
    public void create(String docName) {
        decorator.create(docName);
        System.out.println("打印日志");
    }
}
