package com.exercise.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class createFile {

    public void method1(){
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method2(){
        String parentPath = "C:\\Users\\依格\\Desktop\\repository\\";
        try {
            new File(parentPath,"newFile2.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void method3(){
        File file = new File("C:\\Users\\依格\\Desktop\\repository\\");
        try {
            new File(file,"newFile3.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
