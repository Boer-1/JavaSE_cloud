package com.homework;

public class TestShape {
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

        System.out.println(shape);
        System.out.println(circle);
        System.out.println(rectangle);
    }
}
class Shape{
    protected double area;
    protected double perimeter;

    public void area(){}
    public void perimeter(){}
    @Override
    public String toString() {
        return "Shape" + "{area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
class Circle extends Shape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void perimeter() {
        perimeter = 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return "Circle" + "{area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void area() {
        area = length * width;
    }

    @Override
    public void perimeter() {
        perimeter = 2 * (length + width);
    }
    @Override
    public String toString() {
        return "Rectangle" + "{area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}