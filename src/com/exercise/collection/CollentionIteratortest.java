package com.exercise.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollentionIteratortest {
    public static void main(String[] args) {
        @SuppressWarnings({"all"})
        List arrayList = new ArrayList();
        arrayList.add(new Dog("Tom",3));
        arrayList.add(new Dog("Jack",4));

        Iterator iterator1 = arrayList.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("=====");
        for(Object dog : arrayList){
            System.out.println(dog);
        }

    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "" + name + " "+ age;
    }
}