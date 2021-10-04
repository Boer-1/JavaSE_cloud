package com.exercise.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server 等待中····");
        Socket socket = serverSocket.accept();
        //打印收到的信息：
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        //回客户端消息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello,client");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
