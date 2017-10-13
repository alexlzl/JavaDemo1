package com.tset;

import java.lang.ref.*;
import java.util.HashSet;

/**
 * Created by liuzhouliang on 2017/10/13.
 */
public class Demo3 {
    public static ReferenceQueue<Store> queue = new ReferenceQueue<Store>();

    public static void checkQueue() {
        if (queue != null) {
            @SuppressWarnings("unchecked")
            Reference<Store> ref = (Reference<Store>) queue.poll();
            if (ref != null)
                System.out.println(ref + "......" + ref.get());
        }
    }

    public static void main(String[] args) {

        HashSet<SoftReference<Store>> hs1 = new HashSet<SoftReference<Store>>();
        HashSet<WeakReference<Store>> hs2 = new HashSet<WeakReference<Store>>();

        //创建10个软引用
        for (int i = 1; i <= 10; i++) {
            SoftReference<Store> soft = new SoftReference<Store>(new Store("soft" + i), queue);
            System.out.println("create soft" + soft.get());
            hs1.add(soft);
        }
        System.gc();
        checkQueue();

        //创建10个弱引用
        for (int i = 1; i <= 10; i++) {
            WeakReference<Store> weak = new WeakReference<Store>(new Store("weak" + i), queue);
            System.out.println("create weak" + weak.get());
            hs2.add(weak);
        }

        System.gc();
        checkQueue();
        //创建10个虚引用
        HashSet<PhantomReference<Store>> hs3 = new HashSet<PhantomReference<Store>>();
        for (int i = 1; i <= 10; i++) {
            PhantomReference<Store> phantom = new PhantomReference<Store>(new Store("phantom" + i), queue);
            System.out.println("create phantom  " + phantom.get());
            hs3.add(phantom);
        }
        System.gc();
        checkQueue();
    }


}
