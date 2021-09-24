package com.exercise.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class properties_tradition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        "C:\\Users\\依格\\Desktop" +
                                "\\repository\\local.properties"));
        String line;
        //逐行找出ip，并打印出ip值
        while ((line = bufferedReader.readLine()) != null){
            String[] split = line.split("=");
            if("ip".equals(split[0])){
                System.out.println(split[1]);
            }
        }
        bufferedReader.close();

    }
}
