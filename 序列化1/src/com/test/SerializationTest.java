package com.test;

import java.io.IOException;

/**
 * Created by liuzhouliang on 2018/1/25.
 * <p>
 * Java序列化允许java类中的一些变化，如果他们可以被忽略的话。一些不会影响到反序列化处理的变化有：
 * <p>
 * 在类中添加一些新的变量。
 * 将变量从transient转变为非tansient，对于序列化来说，就像是新加入了一个变量而已。
 * 将变量从静态的转变为非静态的，对于序列化来说，就也像是新加入了一个变量而已。
 */
public class SerializationTest {
    public static void main(String[] args) {
        String fileName = "employee.ser";
        Employee emp = new Employee();
        Child child=new Child();
        child.age=100;
        child.time=2011;
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
        emp.child=child;

//        serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("emp Object::" + emp);
        System.out.println("empNew Object::" + empNew);
    }

}
