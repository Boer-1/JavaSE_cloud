package com.exercise.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3Server {
    public static void main(String[] args) throws IOException {
        //9999端口开始监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server正在监听···");
        Socket socket = serverSocket.accept();
        //接收客户端消息
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = bufReader.readLine()) != null){
            stringBuilder.append(str);
        }
        String message = stringBuilder.toString();
        //处理请求
        BufferedOutputStream bufOutputStream = new BufferedOutputStream(socket.getOutputStream());
        String[] strings = new String[2];
        strings[0] = "01.png";
        strings[1] = "02.png";
        String directory = "C:\\Users\\依格\\wrong_rea\\Pictures\\good\\";
        boolean tag = false;
        //遍历，找到则传输对应文件
        for(String match :strings){
            if(message.equals(match)){
                String sourcePath = directory + match;
                BufferedInputStream bufInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
                byte[] bytes = new byte[1024];
                int length;
                while ((length = bufInputStream.read(bytes)) != -1){
                    bufOutputStream.write(bytes,0,length);
                }
                bufOutputStream.flush();
                socket.shutdownOutput();
                tag = true;
            }
        }
        //没找到，则传输一个默认文件
        if(!tag){
            String sourcePath = directory + strings[0];
            BufferedInputStream bufInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
            byte[] bytes = new byte[1024];
            int length;
            while ((length = bufInputStream.read(bytes)) != -1){
                bufOutputStream.write(bytes,0,length);
            }
            bufOutputStream.flush();
            socket.shutdownOutput();
        }
        //over
        System.out.println("Successfully transmit");
        bufOutputStream.close();
        bufReader.close();
        socket.close();
        serverSocket.close();
    }
}
