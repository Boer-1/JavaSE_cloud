package com.exercise.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
    @Test
    public void fileInputStream_1(){
        int readData;
        FileInputStream fileInputStream = null;
        try {
            String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
            fileInputStream = new FileInputStream(filePath);
            //得到的是单个字节的int值
            while ((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void fileInputStream_2(){
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
        byte[] bytesData = new byte[8];
        int length;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((length = fileInputStream.read(bytesData)) != -1){
                System.out.print(new String(bytesData, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
