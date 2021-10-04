package com.exercise.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient3 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello,server");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println("Client 发送完毕···");
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        //后打开的先关闭
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        socket.close();
    }
}
