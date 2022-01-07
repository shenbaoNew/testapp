package com.digiwin.testapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:ApiVersion
 * Author: shenbao
 * Date: 2022/1/7 10:59
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {
    String value();
}
