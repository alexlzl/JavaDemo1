package com.test;

import java.io.*;

/**
 * Created by liuzhouliang on 2018/1/26.
 * <p>
 * Externalizable继承于Serializable，当使用该接口时，序列化的细节需要由程序员去完成。
 * <p>
 * Externalizable继承于Serializable，当使用该接口时，序列化的细节需要由程序员去完成。如上所示的代码，由于writeExternal()与readExternal()方法未作任何处理，那么该序列化行为将不会保存/读取任何一个字段。这也就是为什么输出结果中所有字段的值均为空。
 * 另外，使用Externalizable进行序列化时，当读取对象时，会调用被序列化类的无参构造器去创建一个新的对象，然后再将被保存对象的字段的值分别填充到新对象中。这就是为什么在此次序列化过程中Person类的无参构造器会被调用。由于这个原因，实现Externalizable接口的类必须要提供一个无参的构造器，且它的访问权限为public。
 */
public class Person implements Externalizable {
    private String name = null;

    transient private Integer age = null;


    public Person() {
        System.out.println("none-arg constructor");
    }

    public Person(String name, Integer age) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "name==="+name+"age==="+age;
    }
}
