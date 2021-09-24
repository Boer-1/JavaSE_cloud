package com.homework;

public class TestQuadEquation {
    public static void main(String[] args) {
        //创建对象： x^2-5x+6=0 求解（两个不同根）
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, -5, 6);
        quadraticEquation.printInfo();
        //修改值为： x^2-5x+10=0 求解（无解）
        quadraticEquation.setC(10);
        quadraticEquation.printInfo();
        //修改值为：x^2-4x+4=0 求解（两个相同根）
        quadraticEquation.setB(-4);
        quadraticEquation.setC(4);
        quadraticEquation.printInfo();
    }
}
