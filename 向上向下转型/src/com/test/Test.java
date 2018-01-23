package com.test;

/**
 * Created by liuzhouliang on 2018/1/23.
 */
public class Test {
    public static void main(String[] args) {

        Animal b = new Bird(); //向上转型

        b.eat();

//        b.fly();  //此处提示在Animal中没有定义fly方法。
    }
}
