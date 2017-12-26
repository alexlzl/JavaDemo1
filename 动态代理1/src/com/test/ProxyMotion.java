package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


/**
 * 在java中提供了一个动态代理类，这个类位于java.lang.reflect包中的Proxy类中。什么是动态代理类呢？就是可以在运行时创建一个实现了一组给定接口的新类。听上去有点高深的样子，其实是提供了一种类的包装器，最终对接口中方法的调用还是由现有的接口的实现类去调用。
 * <p>
 * 比如，现在有一个ArrayList的对象，可以向其中添加任意的string对象，但是我们不需要添加apple这个字符串。ArrayList默认是不会提供这种字符串过滤的方法的，这个时候我们就可以使用Proxy代理类，在这个类中我们添加字符串的过滤规则，然后决定当前的字符串是否可以被添加到ArrayList中去。
 * <p>
 * Proxy类中提供了一个方便的static方法用来构造proxy对象。Proxy.newProxyInstance(ClassLoader ,Class<?>[] interfaces, Invocationhandler).
 * <p>
 * 参数classLoader：类的加载器，使用null表示使用默认的加载器。
 * <p>
 * 参数 interfaces：需要代理的接口数组。
 * <p>
 * invocationHandler:调用处理器，使用新建的proxy对象调用方法的时候，都会调用到该接口中的invoke方法。
 * Created by Charles on 2015/11/2.
 */
public class ProxyMotion {

    public static void main(String args[]) {

        ArrayList<String> content = new ArrayList<String>();
        MyInvocationHandler handler = new MyInvocationHandler(content);
        Object proxy = Proxy.newProxyInstance(null, new Class[]{List.class}, handler);
        if (proxy instanceof List) {  //判断当前的proxy对象是否是List接口
            System.out.println("proxy is list");
            List<String> mlist = (List<String>) proxy;
            mlist.add("one");
            mlist.add("two");
            mlist.add("three");
            mlist.add("apple");
        }
        System.out.println("proxy:" + proxy.toString());
        System.out.println("content:" + content.toString());
    }

}

class MyInvocationHandler implements InvocationHandler {
    //具体的调用类
    Object target;

    public MyInvocationHandler(Object obj) {
        target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //当前所持有的proxy对象
        //method表示当前别调用的方法
        //args表示方法中传递的参数
        System.out.println("method name:" + method.getName());
        if (method.getName().equals("add")) {
            if (args[0].equals("apple")) {
                return false;
            }
        }
        return method.invoke(target, args);
    }
}