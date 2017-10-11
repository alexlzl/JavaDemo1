package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liuzhouliang on 2017/10/11.
 */
public class BusinessProcessorHandler implements InvocationHandler {

    private Object target = null;

    BusinessProcessorHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if(method.getName().equals("test")){
            System.out.println("==test 方法===");
        }
        if(method.getName().equals("test1")){
            System.out.println("==test1 方法===");
        }
        if(method.getName().equals("processBusiness")){
            System.out.println("==processBusiness 方法===");
        }
        System.out.println("You can do something here before process your business");
        Object result = method.invoke(target, args);
        System.out.println("You can do something here after process your business");
        return result;
    }
}
