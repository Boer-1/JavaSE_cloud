package com.homework;

import java.util.HashSet;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double discriminant;//判别式结果

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        discriminant = Math.pow(b,2) - 4 * a * c;
        return discriminant >= 0? discriminant:-1;
    }
    public HashSet<Double> solutionOfEquation(){
        if((discriminant = getDiscriminant()) != -1){
            HashSet<Double> hashSet = new HashSet<>();
            double res1 = ( Math.sqrt(discriminant) - b)/2 * a;
            double res2 = (-Math.sqrt(discriminant) - b)/2 * a;
            hashSet.add(res1);
            hashSet.add(res2);
            return hashSet;
        }else {
            return null;
        }
    }
    public void printInfo(){
        HashSet<Double> hashSet = this.solutionOfEquation();
        System.out.println(this.getA() + "x^2+" +
                this.getB() + "x+" +
                this.getC() + "=0 ");
        if(hashSet != null){
            System.out.print("的解分别是：");
            for(Double res : hashSet){
                System.out.print(res + "\t");
            }
            System.out.println("\n");
        }else {
            System.out.println("Error:The equation has no solution value\n");
        }
    }
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

}
