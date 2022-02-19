package com.digiwin.testapp.annotation;

import java.lang.annotation.*;

/**
 * FileName:ApiInvoker
 * Author: shenbao
 * Date: 2022/2/19 21:33
 * Description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = MulApiInvoker.class)
public @interface ApiInvoker {
    /**
     * 调用方服务名称
     *
     * @return
     */
    String caller();

    /*
    服务方服务名称
     */
    String serviceName();
}
