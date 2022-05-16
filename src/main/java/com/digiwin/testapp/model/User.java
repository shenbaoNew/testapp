package com.digiwin.testapp.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * FileName:User
 * Author: shenbao
 * Date: 2021/12/27 22:20
 * Description:
 */
public class User {
    private String code;
    private String name;

    public User() {
    }

    public User(String code, String name) {
        if (code == null) {
            throw new RuntimeException("用户编号不可为空");
        }
        if (name == null) {
            throw new RuntimeException("用户名称不可为空");
        }
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
