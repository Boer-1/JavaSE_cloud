package com.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server 等待中····");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        //打印收到的信息：
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,length));
        }

        //回客户端消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
