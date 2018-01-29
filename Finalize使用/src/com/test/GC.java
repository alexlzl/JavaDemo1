package com.test;

/**
 * Created by liuzhouliang on 2018/1/29.
 * <p>
 *     对象复活
 * execute method finalize()
 * Yes , I am still alive
 * No , I am dead
 *
 * 大致描述一下finalize流程：当对象变成(GC Roots)不可达时，GC会判断该对象是否覆盖了finalize方法，若未覆盖，则直接将其回收
 * https://www.cnblogs.com/Smina/p/7189427.html
 */
public class GC {
    public static GC SAVE_HOOK = null;

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new GC();
        SAVE_HOOK = null;//对象变成(GC Roots)不可达=============1
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) { //此时对象应该处于(reachable, finalized)状态
            System.out.println("Yes , I am still alive");
        } else {
            System.out.println("No , I am dead");
        }
        SAVE_HOOK = null;//对象变成(GC Roots)不可达==================3
        System.gc();
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            System.out.println("Yes , I am still alive");
        } else {
            System.out.println("No , I am dead");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute method finalize()");
        SAVE_HOOK = this;//复活对象，对象变成(GC Roots)可达==============2
    }
}
