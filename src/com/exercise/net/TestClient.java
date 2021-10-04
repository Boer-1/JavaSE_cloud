package com.exercise.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("172.16.188.74"), 9999);
        BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);

        System.out.println("有什么问题吗？请输入");
        String question = scanner.next();
        bufWriter.write(question);
        bufWriter.flush();
        socket.shutdownOutput();
        //接收回复
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = bufReader.readLine()) != null) {
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder.toString());


//        over
        bufReader.close();
        bufWriter.close();
        socket.close();
    }
}
