package com.exercise;

public class EqualsTest {
    public static void main(String[] args) {
        AA tom = new AA("Tom", 20);
        AA jack = new AA("Jack", 20);
        System.out.println(tom.equals(jack));


    }
}
class AA{
    private String name;
    private int age;

    public AA(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public AA(){}
    public boolean equals(AA aa){
        return this.age == aa.age;
    }

}
