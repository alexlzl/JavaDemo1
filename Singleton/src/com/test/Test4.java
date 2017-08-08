package com.test;

/**
 * ---------运行静态块的代码------------
 --------运行实例块/初始化块的代码--------
 --------运行构造函数的代码-------
 静态变量name现在的值是Jam

 */
public class Test4 {
    public static void main(String[] args) {
        X1 x = new X1();
    }
}
 class X1 {
    static String name = "rjx";

    static {
        System.out.println("---------运行静态块的代码------------");
        name = "Jam";
    }

    {
        System.out.println("--------运行实例块/初始化块的代码--------");
    }

    public X1() {
        System.out.println("--------运行构造函数的代码-------");
        System.out.println("静态变量name现在的值是" + name);
    }
}