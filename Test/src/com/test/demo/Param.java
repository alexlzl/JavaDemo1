package com.test.demo;

public class Param {

    private String name;

    public static void main(String[] args) {
        Param param = new Param();
        param.setName("lzl");
        TestF testF = new TestF(param);
        testF.test();//lzl
        param.setName("alex");
        testF.test();//alex
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
