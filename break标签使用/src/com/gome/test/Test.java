package com.gome.test;

/**
 * Created by liuzhouliang on 2017/9/18.
 */
public class Test {
    private static Test ourInstance = new Test();

    public static Test getInstance() {
        return ourInstance;
    }

    private Test() {
    }
}
