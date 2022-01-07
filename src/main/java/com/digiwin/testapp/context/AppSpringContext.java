package com.digiwin.testapp.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * FileName:SpringBeanUtils
 * Author: shenbao
 * Date: 2021/12/22 16:06
 * Description:
 */
public class AppSpringContext implements ApplicationContextAware {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public AppSpringContext() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        T bean = (T) context.getBean(name);
        return bean;
    }
}
