package com.test;

import java.io.Serializable;

/**
 * Created by liuzhouliang on 2018/1/26.
 */
public class Child implements Serializable{
    private static final long serialVersionUID = 2L;
    public int age;
    public int time;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
