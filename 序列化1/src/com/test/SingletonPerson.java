package com.test;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by liuzhouliang on 2018/1/26.
 * 这种序列化方式仅仅对对象的非transient的实例变量进行序列化，而不会序列化对象的transient的实例变量，也不会序列化静态变量。
 */
public class SingletonPerson implements Serializable {

    private static class InstanceHolder {
        private static final SingletonPerson instatnce = new SingletonPerson("John", 31);
    }

    public static SingletonPerson getInstance() {
        return InstanceHolder.instatnce;
    }

    private String name = null;

    private Integer age = null;


    private SingletonPerson() {
        System.out.println("none-arg constructor");
    }

    private SingletonPerson(String name, Integer age) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
    }

    /**
     * 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
     *
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }
}
