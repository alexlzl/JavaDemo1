package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by liuzhouliang on 2017/10/11.
 * <p>
 * CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却比JDK多得多，所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理！
 *
 * 动态代理有以下特点:
 * 1.代理对象,不需要实现接口
 * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 * 3.动态代理也叫做:JDK代理,接口代理
 * <p>
 * 总结:
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * <p>
 * 1，根据传入的第二个参数interfaces动态生成一个类，实现interfaces中的接口，该例中即BusinessProcessor接口的processBusiness方法。并且继承了Proxy类，重写了hashcode,toString,equals等三个方法。具体实现可参看 ProxyGenerator.generateProxyClass(...); 该例中生成了$Proxy0类
 * <p>
 * 2，通过传入的第一个参数classloder将刚生成的类加载到jvm中。即将$Proxy0类load
 * <p>
 * 3，利用第三个参数，调用$Proxy0的$Proxy0(InvocationHandler)构造函数 创建$Proxy0的对象，并且用interfaces参数遍历其所有接口的方法，并生成Method对象初始化对象的几个Method成员变量
 * <p>
 * 4，将$Proxy0的实例返回给客户端。
 * <p>
 * 现在好了。我们再看客户端怎么调就清楚了。
 * <p>
 * 1，客户端拿到的是$Proxy0的实例对象，由于$Proxy0继承了BusinessProcessor，因此转化为BusinessProcessor没任何问题。
 * <p>
 * BusinessProcessor bp = (BusinessProcessor)Proxy.newProxyInstance(....);
 * <p>
 * 2，bp.processBusiness()；
 * <p>
 * 实际上调用的是$Proxy0.processBusiness();那么$Proxy0.processBusiness()的实现就是通过InvocationHandler去调用invoke方法啦!
 * <p>
 * 其实这里基本上就是AOP的一个简单实现了，在目标对象的方法执行之前和执行之后进行了增强。Spring的AOP实现其实也是用了Proxy和InvocationHandler这两个东西的。
 */
public class Test {
    public static void main(String[] args) {
        BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
        bp.processBusiness();
        bp.test();
        bp.test1("tsss");
        System.out.println(bp.getClass().getName());//com.sun.proxy.$Proxy0
        Class clz = bp.getClass();
        printClassDefinition(clz);
    }

    public static void printClassDefinition(Class clz) {

        String clzModifier = getModifier(clz.getModifiers());
        if (clzModifier != null && !clzModifier.equals("")) {
            clzModifier = clzModifier + " ";
        }
        String superClz = clz.getSuperclass().getName();
        if (superClz != null && !superClz.equals("")) {
            superClz = "extends " + superClz;
        }

        Class[] interfaces = clz.getInterfaces();

        String inters = "";
        for (int i = 0; i < interfaces.length; i++) {
            if (i == 0) {
                inters += "implements ";
            }
            inters += interfaces[i].getName();
        }

        System.out.println(clzModifier + clz.getName() + " " + superClz + " " + inters);
        System.out.println("{");

        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String modifier = getModifier(fields[i].getModifiers());
            if (modifier != null && !modifier.equals("")) {
                modifier = modifier + " ";
            }
            String fieldName = fields[i].getName();
            String fieldType = fields[i].getType().getName();
            System.out.println("    " + modifier + fieldType + " " + fieldName + ";");
        }

        System.out.println();

        Method[] methods = clz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            String modifier = getModifier(method.getModifiers());
            if (modifier != null && !modifier.equals("")) {
                modifier = modifier + " ";
            }

            String methodName = method.getName();

            Class returnClz = method.getReturnType();
            String retrunType = returnClz.getName();

            Class[] clzs = method.getParameterTypes();
            String paraList = "(";
            for (int j = 0; j < clzs.length; j++) {
                paraList += clzs[j].getName();
                if (j != clzs.length - 1) {
                    paraList += ", ";
                }
            }
            paraList += ")";

            clzs = method.getExceptionTypes();
            String exceptions = "";
            for (int j = 0; j < clzs.length; j++) {
                if (j == 0) {
                    exceptions += "throws ";
                }

                exceptions += clzs[j].getName();

                if (j != clzs.length - 1) {
                    exceptions += ", ";
                }
            }

            exceptions += ";";

            String methodPrototype = modifier + retrunType + " " + methodName + paraList + exceptions;

            System.out.println("    " + methodPrototype);

        }
        System.out.println("}");
    }

    public static String getModifier(int modifier) {
        String result = "";
        switch (modifier) {
            case Modifier.PRIVATE:
                result = "private";
            case Modifier.PUBLIC:
                result = "public";
            case Modifier.PROTECTED:
                result = "protected";
            case Modifier.ABSTRACT:
                result = "abstract";
            case Modifier.FINAL:
                result = "final";
            case Modifier.NATIVE:
                result = "native";
            case Modifier.STATIC:
                result = "static";
            case Modifier.SYNCHRONIZED:
                result = "synchronized";
            case Modifier.STRICT:
                result = "strict";
            case Modifier.TRANSIENT:
                result = "transient";
            case Modifier.VOLATILE:
                result = "volatile";
            case Modifier.INTERFACE:
                result = "interface";
        }
        return result;
    }


}
