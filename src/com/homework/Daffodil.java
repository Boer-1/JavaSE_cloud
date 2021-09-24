package com.homework;

public class Daffodil {
    public static void main(String[] args) {
        for(int i = 100;i < 1000;i++){
            int percentile = i / 100;
            int tenths = (i - 100 * percentile)/10;
            int single = i - 100 * percentile - 10 * tenths;
            if(Math.pow(percentile,3) + Math.pow(tenths,3) + Math.pow(single,3) == i){
                System.out.println(i + " is Number of daffodils~");
            }
        }
    }
}
