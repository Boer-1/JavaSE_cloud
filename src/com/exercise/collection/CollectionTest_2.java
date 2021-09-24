package com.exercise.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTest_2 {
    public static void main(String[] args) {
        Car_ bmw = new Car_("BMW", 200000);
        Car_ royce = new Car_("Rolls-Royce", 200000000);
        Car_ jeep = new Car_("Jeep", 500000);
        ArrayList arrayList = new ArrayList();


        //add:添加单个元素
        arrayList.add(bmw);
        arrayList.add(royce);
        arrayList.add(jeep);
        //remove:删除指定元素
        arrayList.remove(0);
        //contains:查找元素是否存在
        System.out.println("contains Rolls-Royce? :" + arrayList.contains(royce));
        //size:获取元素个数
        System.out.println("count:" + arrayList.size());
        //isEmpty:判断是否为空
        System.out.println("is Empty? :" + arrayList.isEmpty());
        //clear:清空
        //arrayList.clear();
        //addAll:添加多个元素
        Car_ bmw2 = new Car_("BMW2", 200000);
        Car_ royce2 = new Car_("Rolls-Royce2", 200000000);
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(arrayList2);
        //containsAll:查找多个元素是否都存在
        System.out.println(arrayList.containsAll(arrayList2));
        //removeAll:删除多个元素
        arrayList.removeAll(arrayList2);

        //no need to downward transformation
        //Enhanced for loop
        System.out.println(arrayList.size());
        for (Object o :arrayList) {
            System.out.println(o);
        }
        //the iterator loop
        System.out.println("==cut-off rule==");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
class Car_{
    private String name;
    private double price;

    public Car_(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car_{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}