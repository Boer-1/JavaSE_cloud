package com.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ServerSocket已创建");
        //ServerSocket可以通过accept返回多个socket
        System.out.println("Server 等待中···");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,length));
        }
        //关闭
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
