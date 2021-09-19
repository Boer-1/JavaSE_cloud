package com.exercise.sourceCode_scan;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSource {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i = 0 ;i < 3;i++){
            linkedList.add(i);
        }
        linkedList.remove();
        System.out.println(linkedList);
        linkedList.set(1,999);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
