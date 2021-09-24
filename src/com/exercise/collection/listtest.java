package com.exercise.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class listtest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.add("hello4");
        list.add("hello5");
        list.add("hello6");
        list.add("hello7");
        list.add("hello8");
        list.add("hello9");
        list.add("hello10");
        list.add(2,"hsp");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6,"removed");
        Iterator iterator = list.iterator();
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
