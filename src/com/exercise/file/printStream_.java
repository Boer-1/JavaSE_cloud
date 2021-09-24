package com.exercise.file;

import java.io.IOException;
import java.io.PrintStream;

public class printStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        printStream.println("Jack");
        //底层调用的是write方法
        printStream.write("Jack".getBytes());
        printStream.close();

        //修改字节打印流的输出位置/设备
        System.setOut(new PrintStream("C:\\Users\\依格\\Desktop\\repository\\newFile2.txt"));
        System.out.println("I come here~");
    }
}
