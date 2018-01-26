package com.test;

import java.io.*;

/**
 * Created by liuzhouliang on 2018/1/26.
 * <p>
 * arg constructor
 * none-arg constructor
 * com.test.Person@214c265e
 */
public class PersonTest {
    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 101);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson.toString());
    }
}
