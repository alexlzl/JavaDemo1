package com.test;

/**
 * Created by liuzhouliang on 2018/1/23.
 * <p>
 * 对于多态，可以总结以下几点：
 * 一、使用父类类型的引用指向子类的对象；
 * 二、该引用只能调用父类中定义的方法和变量；
 * 三、如果子类中重写了父类中的一个方法，那么在调用这个方法的时候，将会调用子类中的这个方法；（动态连接、动态调用）
 * 四、变量不能被重写（覆盖），”重写“的概念只针对方法，如果在子类中”重写“了父类中的变量，那么在编译时会报错。
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Father child = new Child();
        child.func1();//打印结果将会是什么？

    }
}
