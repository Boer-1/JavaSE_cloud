package com.exercise.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test_1 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\mytemp";
        File file = new File(filePath);
        if(file.exists()&&file.isDirectory()) {
            System.out.println("file.exists");
        } else {
            file.mkdirs();
        }
        String fileName = "C:\\Users\\依格\\Desktop\\repository\\mytemp\\hello.txt";
        File file1 = new File(fileName);
        if(file1.exists()){
            System.out.println("It already exists2");
        }else {
            file1.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("hello,world~");
        fileWriter.close();
    }
}
