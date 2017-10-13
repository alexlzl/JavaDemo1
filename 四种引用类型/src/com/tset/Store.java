package com.tset;

/**
 * Created by liuzhouliang on 2017/10/13.
 */
public class Store {
    public static final int SIZE = 10000;
    private double[] arr = new double[SIZE];
    private String id;

    public Store() {

    }

    public Store(String id) {
        super();
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(id + "被回收了");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }


}
