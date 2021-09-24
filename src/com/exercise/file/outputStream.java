package com.exercise.file;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class outputStream {
    @Test
    public void FileOutputStream(){
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile2.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write('W');
            fileOutputStream.write(filePath.getBytes(),0,3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
