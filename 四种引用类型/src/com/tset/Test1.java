package com.tset;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by liuzhouliang on 2017/10/13.
 */
public class Test1 {

    public static void main(String[] args) {
        //这就是一个强引用
        String str = "hello";
        ReferenceQueue<? super String> q = new ReferenceQueue<String>();
        //现在我们由上面的强引用创建一个虚引用,所以现在str有两个引用指向它
        PhantomReference<String> p = new PhantomReference<String>(str, q);
        //可以使用get()得到引用指向的对象
        System.out.println(q.poll());//输出null
    }


}
