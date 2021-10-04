package com.exercise.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        //创建指定socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];

        outputStream.write("洞妖洞妖，我是02".getBytes());
        socket.close();

    }
}
