package com.test.demo;

import java.lang.reflect.Field;

public class Test extends TestF<Param> {

    public Test(Param param) {
        super(param);
    }

    public static  void main(String[] args){
        System.out.println("test");
        R r=new R();
        r.setAge("100");
        r.setName("lzl");
       Field[] fields= r.getClass().getDeclaredFields();
       System.out.println(fields.toString()+"field==="+fields.length);
       for (Field field:fields){
           try {
               field.setAccessible(true);
               Object o= field.get(r);
               System.out.println("obj=="+o.toString());
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }
}
