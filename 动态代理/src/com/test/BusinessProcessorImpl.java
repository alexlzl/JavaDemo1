package com.test;

/**
 * Created by liuzhouliang on 2017/10/11.
 */
public class BusinessProcessorImpl implements BusinessProcessor {
    @Override
    public void processBusiness() {
        System.out.println("执行processBusiness方法==============");
    }

    @Override
    public void test() {
        System.out.println("执行test方法=============");
    }

    @Override
    public void test1(String arg) {
        System.out.println("执行test1方法=============");
    }
}
