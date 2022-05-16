package com.digiwin.testapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * FileName:ServiceAop
 * Author: shenbao
 * Date: 2022/5/15 15:19
 * Description:
 *
 * @author mi
 */
@Component
@Aspect
public class ServiceAop {
    @Pointcut("execution(* com.digiwin.testapp.service..*.test(..))")
    public void pointcut() {

    }

    @Pointcut("execution(* com.digiwin.testapp.aop.LogTester.debug(String))")
    public void pointcut1() {

    }

    //@Pointcut("execution(* com.digiwin.testapp.model.Customer.getName(..))")
    public void pointcut2(){
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("before ...");
    }

    @Before("pointcut1()")
    public void before1() {
        System.out.println("before1...");
    }

    //@Before("pointcut2()")
    public void before2(){
        System.out.println("customer getname before ...");
    }
}
