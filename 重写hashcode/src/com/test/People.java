package com.test;

import java.util.HashMap;

/**
 * Created by liuzhouliang on 2018/1/31.
 * http://www.importnew.com/18851.html
 */
public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return name.hashCode() * 37 + age;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.name.equals(((People) obj).name) && this.age == ((People) obj).age;
    }
}

 class Main {

    public static void main(String[] args) {

        People p1 = new People("Jack", 12);
        System.out.println(p1.hashCode());

        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
        hashMap.put(p1, 1);

        System.out.println(hashMap.get(new People("Jack", 12)));
    }
}
