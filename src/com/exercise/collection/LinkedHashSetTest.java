package com.exercise.collection;

import java.util.*;

public class LinkedHashSetTest {
    public static void main(String[] args) {
//        LinkedHashSet linkedHashSet = new LinkedHashSet();
//        linkedHashSet.add(new Car("Alto",20000));
//        linkedHashSet.add(new Car("Alto",20000));
//        linkedHashSet.add(new Car("Ferrari",2000000));
//        //judgement based name&price ,so, size() should be 2,not 3
//        System.out.println(linkedHashSet.size());
        Map map = new HashMap();
        map.put("aa","bb");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(((Map.Entry)(iterator.next())).getValue());
        }

    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}