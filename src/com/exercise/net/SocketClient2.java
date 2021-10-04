package com.exercise.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();
        System.out.println("Client 发送完毕···");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,length));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
