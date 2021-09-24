package com.exercise.file;

import java.io.*;

public class copyFile_Buffered_byte {
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "C:\\Users\\依格\\Desktop\\repository\\beauty2.jpeg";
        String targetFilePath = "C:\\Users\\依格\\Desktop\\repository\\beauty3.jpeg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFilePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFilePath));
        byte[] bytes = new byte[8];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,length);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
