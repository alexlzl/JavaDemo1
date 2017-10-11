package com.test;

/**
 * Created by liuzhouliang on 2017/10/11.
 * 静态代理总结:
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * <p>
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * 如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
 */
public class UserDaoProxy implements IUserDao {
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
