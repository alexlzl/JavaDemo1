package com.test;

import java.io.*;

/**
 * Created by liuzhouliang on 2018/1/26.
 * <p>
 * arg constructor
 * none-arg constructor
 * name===Johnage===31
 * false
 * <p>
 * 值得注意的是，从文件person.out中获取的Person对象与Person类中的单例对象并不相等。为了能在序列化过程仍能保持单例的特性，可以在Person类中添加一个readResolve()方法，在该方法中直接返回Person的单例对象，
 */
public class SingletonPersonTest {
    public static void main(String[] args) throws Exception {
        File file = new File("person.out");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(SingletonPerson.getInstance()); // 保存单例对象
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);

        System.out.println(SingletonPerson.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
    }
}
