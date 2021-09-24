package com.homework;

public class Multiplication_tables {
    public static void main(String[] args) {
        int[][] table= new int[9][];
        System.out.println("Multiplication_tables:");
        for(int i = 0;i < table.length;i++){
            table[i] = new int[i + 1];
            for(int j = 0;j < table[i].length;j++){
                table[i][j] = (i + 1) * (j + 1);
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
