package com.test;

/**
 * Created by liuzhouliang on 2018/1/30.
 */
public class Test {
    public static void main(String[] args){
        Student student=new Student();
        Student student1=new Student();
        if(student==student1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
    }

}
