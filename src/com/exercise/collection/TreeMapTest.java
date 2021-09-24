package com.exercise.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo(((String)o2));
            }
        });
        treeMap.put("Tom","999");
        treeMap.put("aag","999");
        treeMap.put("aag","999");
        treeMap.put("cac","999");
        treeMap.put("cbg","999");
        System.out.println(treeMap);


    }
}
