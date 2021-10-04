package com.exercise.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileCopyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server 已启动···");
        Socket socket = serverSocket.accept();
        String storePath = "C:\\Java\\Project\\Java_IDEA\\Java_base\\src\\com\\exercise\\net\\beauty_copy.jpeg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        //将传输过来的文件，输出到指定目录下
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(storePath));
        byte[] bytes = new byte[1024];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,length);
        }
        bufferedOutputStream.flush();
        System.out.println("图片已接收");

        //回复客户端
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();

        //over
        bufferedWriter.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();


    }
}
