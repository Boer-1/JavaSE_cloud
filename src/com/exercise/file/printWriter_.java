package com.exercise.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class printWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("sdf");
        printWriter.close();

        //
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("C:\\Users\\依格\\Desktop\\repository\\newFile2.txt"));
        printWriter1.println("I am here again");
        printWriter1.close();

    }
}
