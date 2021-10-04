package com.homework;

public class TestPlurality {
    public static void main(String[] args) {
        Plurality plurality = new Plurality(4, 5);
        System.out.print("原式：  \t\t");
        System.out.println(plurality.toString());//.toString 赘余
        System.out.print("实部加1后：  \t");
        plurality.add(1);
        System.out.println(plurality);
        System.out.print("虚部减1后：  \t");
        plurality.sub(1);
        System.out.println(plurality);
        Plurality plurality1 = new Plurality(2, 2);
        System.out.print("加 式“2+2i”后：");
        plurality.add(plurality1);
        System.out.println(plurality);
    }
}
class Plurality{
    private double real;
    private double imaginary;

    public Plurality(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Plurality(){}//默认构造器，重载

    public void add(Plurality plurality){
        this.real = this.real + plurality.real;
        this.imaginary = this.imaginary + plurality.imaginary;
    }
    public void add(double real){//只加实部，重载
        this.real = this.real + real;
    }
    public void sub(Plurality plurality){
        this.real = this.real - plurality.real;
        this.imaginary = this.imaginary - plurality.imaginary;
    }
    public void sub(double imaginary){//只减虚部，重载
        this.imaginary = this.imaginary - imaginary;
    }
    public String toString(){
        return real + "+" + imaginary + "i";
    }

}
