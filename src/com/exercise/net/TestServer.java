package com.exercise.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server等待中···");
        Socket socket = serverSocket.accept();
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        while ((str = bufReader.readLine()) != null) {
            stringBuilder.append(str);
        }
        String message = stringBuilder.toString();
        String answer;
        if ("name".equals(message)) {
            answer = "我是nova";
        } else if ("hobby".equals(message)) {
            answer = "编写Java程序";
        } else {
            answer = "纳尼???";
        }
        BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufWriter.write(answer);
        bufWriter.flush();
        socket.shutdownOutput();
        //over
        System.out.println("Server结束···");
        bufWriter.close();
        bufReader.close();
        socket.close();
        serverSocket.close();
    }
}
