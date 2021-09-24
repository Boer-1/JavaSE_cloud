package com.exercise.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class copyFile {
    @Test
    public void fileIOStream() {
        String sourcePath = "C:\\Users\\依格\\wrong_rea\\Pictures\\good\\beauty.jpeg";
        String targetPath = "C:\\Users\\依格\\Desktop\\repository\\beauty2.jpeg";
        byte[] bytes = new byte[8];
        int length;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(sourcePath);
            fileOutputStream = new FileOutputStream(targetPath);
            while ((length = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void fileReader_Writer() {
        String sourcePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
        String targetPath = "C:\\Users\\依格\\Desktop\\repository\\newFile3.txt";
        char[] chars = new char[8];
        int length;
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(sourcePath);
            fileWriter = new FileWriter(targetPath,true);
            while ((length = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,length);
                System.out.print(new String(chars,0,length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                //fileWriter一定要关闭或刷新，才能写入文件
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
