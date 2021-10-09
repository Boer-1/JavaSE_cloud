package com.homework;

public class StaticMethodTest {
    public static void main(String[] args) {
        StaticMethod.callMe(); // 用类之间调用静态方法
        StaticMethod sm = new StaticMethod();
        sm.callMe(); // 利用对象来调用静态方法
    }
}
class StaticMethod{
    public static void callMe(){ // 定义静态方法
        System.out.println("This is a static method.");
    }
}
