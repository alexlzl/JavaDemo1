package com.test;

/**
 * --------运行实例块/初始化块的代码--------
 --------运行构造函数的代码-------
 静态变量name现在的值是null
 ---------运行静态块的代码------------
 --------运行实例块/初始化块的代码--------
 --------运行构造函数的代码-------
 静态变量name现在的值是Jam


 阎宏在《Java与模式》也有精辟的总结：在Java 编译器中，Singleton 类的初始化与instance变量赋值的顺序不可预料。 如果一个线程在没有同步化的条件下读取instance 引用，并调用这个对象的方法的话，可能会发现对象的初始化过程尚未完成，从而造成崩溃。
 由于JMM天生的无序性，导致了在Singleton构造函数执行之前，变量instance可能成为非null !!
 */
public class Test {

    public static void main(String[] args) {
        X x = new X();
    }

}

class X {
    /*增加自己的静态实例变量*/
    static X x = new X();
    static String name = "rjx";

    static {
        System.out.println("---------运行静态块的代码------------3");
        name = "Jam";
    }

    {
        System.out.println("--------运行实例块/初始化块的代码--------1");
    }

    public X() {
        System.out.println("--------运行构造函数的代码-------2");
        System.out.println("静态变量name现在的值是======2" + name);
    }
}