package com.exercise.file;

import java.io.*;

public class Test_2 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile2.txt";
        BufferedReader bufferedReader;
        String line;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath),"GBK");
        bufferedReader = new BufferedReader(inputStreamReader);

        for(int i = 1;(line = bufferedReader.readLine()) != null;i++){
            System.out.println(i + "." + line);
        }
        bufferedReader.close();
    }
}
