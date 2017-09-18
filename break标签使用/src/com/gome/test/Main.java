package com.gome.test;

/**
 * Created by liuzhouliang on 2017/9/18.
 * <p>
 * 很多程序设计语言中有goto语句，goto语句的使用，使的程序变得难以读懂，尽管goto仍是Java的一个保留字，但并未在语言中得到正式使用；Java没有goto。然而，在break和continue这两个关键字的身上，我们仍然能看出一些goto的影子。它并不属于一次跳转，而是中断循环语句的一种方法。之所以把它们纳入goto问题中一起讨论，是由于它们使用了相同的机制：标签
 */
public class Main {
    public static void main(String[] strings) {

        System.out.println("main====");
        System.out.println("循环开始");
//        out:
        for (int i = 0; i < 5; i++) {
            System.out.println("i==" + i);
            out:
            for (int a = 0; a < 5; a++) {
                System.out.println("a==" + a);
                if (a == 2)
                    break out;
            }
        }
        System.out.println("循环结束");
        test1();
        test2();
        test3();
        test4();

    }

    /**
     * 输出结果是：
     * label1
     * label1===0
     * label1===1
     * 这说明当k=2时，执行了break语句，跳转到了label1标签处，但是并没有在进入这个for语句块。
     */
    public static void test1() {
        System.out.println("label1");
        label1:
        for (int k = 0; k < 5; k++) {
            if (k == 2) {
                break label1;
            }
            System.out.println("label1===" + k);

        }
    }

    /**
     * 输出结果是：
     * label2
     * label2==0
     * label2==1
     * label2==3
     * label2==4
     * 这说明当k=2时，执行了continue语句，跳出了循环没有执行println语句，然后从label2标签的地方再次进入for语句块。
     */
    public static void test2() {
        System.out.println("label2");
        label2:
        for (int k = 0; k < 5; k++) {
            if (k == 2) {
                continue label2;
            }
            System.out.println("label2==" + k);

        }
    }


    /**
     * 下面是对这个用法的总结：
     (1) 简单的一个continue会退回最内层循环的开头（顶部），并继续执行。
     (2) 带有标签的continue会到达标签的位置，并重新进入紧接在那个标签后面的循环
     (3) break会中断当前循环，并移离当前标签的末尾。
     (4) 带标签的break会中断当前循环，并移离由那个标签指示的循环的末尾。
     */
    public static void test3() {
        System.out.println("label3");
        int h = 0;
        label3:
        for (int k = 0; k < 5; k++) {
            System.out.println("label3 第一层");
            for (int m = 0; m < 5; m++) {
                System.out.println("label3 第二层");
                h++;
                if (m == 2) {
                    break label3;
                }
                System.out.println(h);
            }
        }
    }

    public static void test4() {
        System.out.println("label4");
        int l = 0;
        label4:
        for (int k = 0; k < 5; k++) {
            System.out.println("label4 第一层");
            for (int m = 0; m < 5; m++) {
                System.out.println("label4 第二层");
                l++;
                if (m == 2) {
                    continue label4;
                }
                System.out.println(l);
            }
        }
    }
}
