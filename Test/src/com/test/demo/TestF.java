package com.test.demo;

public class TestF {

    //    private Param param=new Param();
    private Param param;

    public TestF(Param param) {
        this.param = param;
    }

    public void test() {
        System.out.println(param.getName());
    }
}
