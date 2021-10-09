package com.homework;
public class StaticCodeDemo {
    private static double d = initStaticVar();

    static{
        System.out.println("调用 initStatocVar()返回值：d="+d);
        d=3.1415;
        System.out.println("静态代码赋值后：d="+d);
    }
    //定义静态方法
    private static double initStaticVar() {
        System.out.println("静态变量默认初始化的值 d="+d);
        return 1;
    }

    public static void main(String[] args) {}
}
