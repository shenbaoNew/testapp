package com.digiwin.testapp.model;

import org.springframework.stereotype.Component;

/**
 * FileName:User
 * Author: shenbao
 * Date: 2021/12/27 22:20
 * Description:
 */
@Component
public class User {
    private String code;
    private String name;

    public User() {
    }

    public User(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
