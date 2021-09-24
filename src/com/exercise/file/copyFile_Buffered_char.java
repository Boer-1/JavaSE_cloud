package com.exercise.file;

import java.io.*;

public class copyFile_Buffered_char {
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "C:\\Users\\依格\\Desktop\\repository\\newFile1.txt";
        String targetFilePath = "C:\\Users\\依格\\Desktop\\repository\\newFile2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFilePath));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
