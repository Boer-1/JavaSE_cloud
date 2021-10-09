package com.homework;

public interface SecondDimGraphic {
    static double PI = Math.PI;
    double area();
    double perimeter();
}

class Test_4_3{
    public static void main(String[] args) {
        SecondDimGraphic secondDimGraphic;

        Round round = new Round(1);
        rectangle rectangle = new rectangle(1, 1);

        //多态特性
        secondDimGraphic = round;
        System.out.println("圆表面积：" + secondDimGraphic.area());
        System.out.println("圆周长：" + secondDimGraphic.perimeter());
        secondDimGraphic = rectangle;
        System.out.println("长方形表面积：" + secondDimGraphic.area());
        System.out.println("长方形体积：" + secondDimGraphic.perimeter());
    }
}

class Round implements SecondDimGraphic{
    private double radius;

    public Round(double radius) {
        this.radius = radius;
    }
    public Round(){}

    @Override
    public double area() {
        return PI * Math.pow(radius,2);
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }
}

class rectangle implements SecondDimGraphic{
    private double length;
    private double width;

    public rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public rectangle(){}

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2*(length + width);
    }

}