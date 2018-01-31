package com.test;

/**
 * Created by liuzhouliang on 2018/1/30.
 */
public class EqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("jack", 18);
        Person p2 = new Person("rose", 17);
        Person p3 = new Person("jack", 18);
        if (p1.equals(p2)) {
            System.out.println("p1.equals p2");
        }
        if (p1.equals(p3)) {
            System.out.println("p1.equals p3");
        }
    }
}
