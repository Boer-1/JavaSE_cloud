package com.exercise.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\依格\\Desktop\\repository\\newFile2.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("In a person's day, all you have to do is to make yourself excellent.");
        bufferedWriter.newLine();
        bufferedWriter.write("In a person's day, all you have to do is to make yourself excellent.");
        bufferedWriter.close();
    }
}
