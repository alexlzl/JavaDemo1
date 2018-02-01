package com.test;

/**
 * Created by liuzhouliang on 2018/2/1.
 * Cloneable和Serializable一样都是标记型接口，它们内部都没有方法和属性，implements Cloneable表示该对象能被克隆，能使用Object.clone()方法。如果没有implements Cloneable的类调用Object.clone()方法就会抛出CloneNotSupportedException。
 * <p>
 * (1)浅克隆（shallow clone），浅拷贝是指拷贝对象时仅仅拷贝对象本身和对象中的基本变量，而不拷贝对象包含的引用指向的对象。
 * (2)深克隆（deep clone），深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。
 * <p>
 * 举例区别一下：对象A1中包含对B1的引用，B1中包含对C1的引用。浅拷贝A1得到A2，A2中依然包含对B1的引用，B1中依然包含对C1的引用。深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2中包含对C2（C1的copy）的引用。
 */
public class Wife implements Cloneable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {//myeclipse自动生成的
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {//myeclipse自动生成的
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Wife other = (Wife) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @param args
     * @throws CloneNotSupportedException （1）x.clone() != x 必须为真，也就是对于基础类型来说，其克隆后在堆中有两个独立且内容相同的内存区域。而对于引用类型来说，其引用也不相同。也就是说克隆对象和原始对象在java 堆(heap)中是两个独立的对象
     *                                    （2）x.clone().getClass() == x.getClass()  他们所属的类是同一个
     *                                    （3） x.clone().equals(x)   所比较的对象内容相同
     *                                    从上述的第二和第三点可以看出，克隆完全是拷贝一个独立的副本到内存中。但是由于克隆方法可以覆写，所以并不能保证克隆出来的对象能够达到（2）和（3）要求的标准，所以他们不是克隆方法所必须要求的
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Wife wife = new Wife(1, "wang");
        Wife wife2 = null;
        wife2 = (Wife) wife.clone();//如果没有implements Cloneable的类调用Object.clone()方法就会抛出CloneNotSupportedException
        System.out.println("class same=" + (wife.getClass() == wife2.getClass()));//true
        System.out.println("object same=" + (wife == wife2));//false 克隆出来的是新对象
        System.out.println("object equals=" + (wife.equals(wife2)));//true 重写了equals 方法 原对象和克隆出的对象逻辑相等
    }
}
