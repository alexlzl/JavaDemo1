package com.test;

import java.io.Serializable;

/**
 * Created by liuzhouliang on 2018/1/25.
 * <p>
 * 为什么 ide 会提示声明 serialVersionUID 的值呢？
 * <p>
 * 因为若不显式定义 serialVersionUID 的值，Java 会根据类细节自动生成 serialVersionUID 的值，如果对类的源代码作了修改，再重新编译，新生成的类文件的serialVersionUID的取值有可能也会发生变化。类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，用不同的Java编译器编译，也有可能会导致不同的serialVersionUID。所以 ide 才会提示声明 serialVersionUID 的值。
 * <p>
 * <p>
 * 如果仅仅只是让某个类实现Serializable接口，而没有其它任何处理的话，则就是使用默认序列化机制。使用默认机制，在序列化对象时，不仅会序列化当前对象本身，还会对该对象引用的其它对象也进行序列化，同样地，这些其它对象引用的另外对象也将被序列化，以此类推。所以，如果一个对象包含的成员变量是容器类对象，而这些容器所含有的元素也是容器类对象，那么这个序列化的过程就会较复杂，开销也较大。
 */
public class Employee implements Serializable {
    //serialVersionUID 就是控制版本是否兼容的，若我们认为修改的 Person 是向后兼容的，则不修改 serialVersionUID；反之，则提高 serialVersionUID的值。再回到一开始的问题，为什么 ide 会提示声明 serialVersionUID 的值呢？
    private static final long serialVersionUID = 3L;
    private String name;
    private int id;
    //如果你想要某个对象属性不被序列化成流，你可以使用transient关键字，正如示例中我在salary变量上的做法那样。
    transient private int salary;
    private String password;
    public Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Employee{name=" + name + ",id=" + id + ",salary=" + salary +"child=="+child+ "}";
    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
