package com.digiwin.testapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:AppService
 * Author: shenbao
 * Date: 2021/12/27 22:49
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AppService {
    public String id() default "";

    public String callback() default "";

    public String[] desc() default {};
}
