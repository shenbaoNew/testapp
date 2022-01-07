package com.digiwin.testapp.context;

import org.springframework.context.ApplicationContext;

/**
 * FileName:SpringBeanUtils
 * Author: shenbao
 * Date: 2021/12/22 16:06
 * Description:
 */
public class AppSpringContext {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        context = context;
    }
}
