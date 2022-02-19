package com.digiwin.testapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:MulApiInvoker
 * Author: shenbao
 * Date: 2022/2/19 21:44
 * Description:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MulApiInvoker {
    ApiInvoker[] value();
}
