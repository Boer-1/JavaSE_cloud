package com.exercise.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_readLine {
    public static void main(String[] args) throws Exception{
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
        BufferedReader bufferedReader = null;
        String line;
        bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
        }
        bufferedReader.close();
    }
}
