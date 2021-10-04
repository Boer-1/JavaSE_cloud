package com.homework;

public class Test_Shape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        circle.setRadius(1);
        //测试重写的求面积，周长方法
        circle.area();
        circle.perimeter();
        //同理测试Rectangle类
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(1);
        rectangle.setWidth(2);
        rectangle.perimeter();
        rectangle.area();

        Shape[] s = new Shape[3];
        s[0] = shape;
        s[1] = circle;
        s[2] = rectangle;
        for(int i = 0;i < s.length;i++){
            System.out.println(s[i].toString());//自动绑定
        }
    }
}
