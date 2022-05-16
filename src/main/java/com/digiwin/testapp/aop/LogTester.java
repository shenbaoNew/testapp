package com.digiwin.testapp.aop;

import com.digiwin.testapp.context.AppSpringContext;
import com.digiwin.testapp.model.Customer;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * FileName:JDKLogTester
 * Author: shenbao
 * Date: 2022/5/15 15:43
 * Description:
 *
 * @author mi
 */
@Component
public class LogTester implements Log {
    public LogTester() {
        System.out.println("init...");
    }

    private String code = "11";

    @Override
    public void debug(String msg) {
        System.out.println("debug:" + msg);

        ////test custom bean
        //Customer customer = new Customer();
        //AppSpringContext.getContext().getAutowireCapableBeanFactory().autowireBean(customer);
        //Customer bean = (Customer) AppSpringContext.getContext().getAutowireCapableBeanFactory()
        //        .applyBeanPostProcessorsAfterInitialization(customer, "customerX");
        //bean.getName();
    }
}
