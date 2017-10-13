package com.tset;

import java.lang.ref.*;
import java.util.HashSet;

/**
 * Created by liuzhouliang on 2017/10/13.
 * <p>
 * "C:\Program Files\Java\jdk1.8.0_101\bin\java" "-javaagent:E:\Ideal\IntelliJ IDEA Community Edition 2017.1.5\lib\idea_rt.jar=65268:E:\Ideal\IntelliJ IDEA Community Edition 2017.1.5\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_101\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar;F:\Java\out\production\四种引用类型" com.tset.Demo3
 * create softsoft1
 * create softsoft2
 * create softsoft3
 * create softsoft4
 * create softsoft5
 * create softsoft6
 * create softsoft7
 * create softsoft8
 * create softsoft9
 * create softsoft10
 * create weakweak1
 * create weakweak2
 * create weakweak3
 * create weakweak4
 * create weakweak5
 * create weakweak6
 * create weakweak7
 * create weakweak8
 * create weakweak9
 * create weakweak10
 * weak3被回收了
 * create phantom  null
 * weak2被回收了
 * weak1被回收了
 * create phantom  null
 * weak10被回收了
 * create phantom  null
 * weak9被回收了
 * create phantom  null
 * weak4被回收了
 * create phantom  null
 * weak6被回收了
 * weak5被回收了
 * weak8被回收了
 * weak7被回收了
 * create phantom  null
 * create phantom  null
 * create phantom  null
 * create phantom  null
 * create phantom  null
 * phantom10被回收了
 * phantom2被回收了
 * phantom1被回收了
 * java.lang.ref.WeakReference@61bbe9ba......null
 * phantom4被回收了
 * phantom3被回收了
 * phantom6被回收了
 * phantom5被回收了
 * phantom9被回收了
 * phantom8被回收了
 * phantom7被回收了
 * <p>
 * Process finished with exit code 0
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
