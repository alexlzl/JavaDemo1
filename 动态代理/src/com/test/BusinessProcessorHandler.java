package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liuzhouliang on 2017/10/11.
 *
 * http://www.cnblogs.com/cenyu/p/6289209.html
 */
public class BusinessProcessorHandler implements InvocationHandler {

    private Object target = null;

    BusinessProcessorHandler(Object target) {
        this.target = target;
    }

    /**
     * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
     * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
     * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if (method.getName().equals("test")) {
            System.out.println("==test 方法===");
        }
        if (method.getName().equals("test1")) {
            System.out.println("==test1 方法===");
        }
        if (method.getName().equals("processBusiness")) {
            System.out.println("==processBusiness 方法===");
        }
        System.out.println("You can do something here before process your business");
        Object result = method.invoke(target, args);
        System.out.println("You can do something here after process your business");
        return result;
    }
}
