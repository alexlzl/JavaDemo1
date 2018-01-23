package com.test;

/**
 * Created by liuzhouliang on 2018/1/23.
 */
public class Test1 {
    public static void main(String[] args) {

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
