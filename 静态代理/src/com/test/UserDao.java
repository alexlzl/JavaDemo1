package com.test;

/**
 * Created by liuzhouliang on 2017/10/11.
 */
public class UserDao implements IUserDao{
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
