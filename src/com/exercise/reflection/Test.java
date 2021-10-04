package com.exercise.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String str = "com.exercise.reflection.PrivateTest";
        //Class类对象
        Class<?> PT_class = Class.forName(str);
        //用默认构造方法获得实例
        Object o = PT_class.newInstance();
        //获得属性
        Field name = PT_class.getDeclaredField("name");
        //爆破修改,因为是private
        name.setAccessible(true);
        name.set(o,"Tom");
        //获得方法
        Method method = PT_class.getMethod("getName");
        //调用方法
        System.out.println(method.invoke(o));


    }
}
class PrivateTest{
    private String name = "helloKitty";
    public String getName(){
        return name;
    }
}
