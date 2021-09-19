package com.exercise.sourceCode_scan;

import java.util.ArrayList;

public class ArrayListSource {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for(int i = 1 ;i <= 10;i++){
            arrayList.add(i);
        }
        for (int i = 11 ;i <= 15;i++){
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);
        for (Object o :arrayList) {
            System.out.println(o);
        }


    }
}
