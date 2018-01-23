package com.test;

/**
 * Created by liuzhouliang on 2018/1/23.
 * <p>
 * 总结：
 * <p>
 * 1、父类引用可以指向子类对象，子类引用不能指向父类对象。
 * <p>
 * 2、把子类对象直接赋给父类引用叫upcasting向上转型，向上转型不用强制转型。
 * <p>
 * 　　 如Father father = new Son();
 * <p>
 * 3、把指向子类对象的父类引用赋给子类引用叫向下转型（downcasting），要强制转型。
 * <p>
 * 　　 如father就是一个指向子类对象的父类引用，把father赋给子类引用son 即Son son =（Son）father；
 * <p>
 * 　　 其中father前面的（Son）必须添加，进行强制转换。
 * <p>
 * 4、upcasting 会丢失子类特有的方法,但是子类overriding 父类的方法，子类方法有效
 * <p>
 * 5、向上转型的作用，减少重复代码，父类为参数，调有时用子类作为参数，就是利用了向上转型。这样使代码变得简洁。体现了JAVA的抽象编程思想。
 */
public class Test1 {
    public static void main(String[] args) {
//        MMGirl girl= (MMGirl) new Girl();会报异常  父类引用可以指向子类对象，子类引用不能指向父类对象。

        Girl g1 = new MMGirl(); //向上转型

        g1.smile();

        MMGirl mmg = (MMGirl) g1;    //向下转型,编译和运行皆不会出错

        mmg.smile();

        mmg.c();

        Girl g2 = new Girl();

        //MMGirl mmg1=(MMGirl)g2; //不安全的向下转型,编译无错但会运行会出错

        //mmg1.smile();

        //mmg1.c();

        if (g1 instanceof MMGirl) {

            MMGirl mmg1 = (MMGirl) g1;

            mmg1.smile();

            mmg1.c();

        }
    }
}
