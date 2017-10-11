package com.test;

import java.lang.reflect.Proxy;

/**
 * Created by liuzhouliang on 2017/10/11.
 */
public class Test {
    public static void main(String[] args) {
        BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
        bp.processBusiness();
        bp.test();
    }
}
