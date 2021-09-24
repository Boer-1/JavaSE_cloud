package com.homework;

public class Prime_Number {
    public static void main(String[] args) {
        int count = 0;
        int ahead = 101;
        int back = 200;
        for (int i = ahead;i < back;i++){
            boolean suppose = true;
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i%j == 0){
                    suppose = false;
                    break;
                }
            }
            if(suppose){
                count++;
                System.out.print(i + "\t");
                if(count%7 == 0) System.out.println("\n");
            }
        }
        System.out.println("区间内素数共" + count + "个");
    }
}
