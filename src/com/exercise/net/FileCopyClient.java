package com.exercise.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileCopyClient { 
    public static void main(String[] args) throws IOException {
        String sourcePath = "C:\\Users\\依格\\wrong_rea\\Pictures\\good\\beauty.jpeg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,length);
        }
        bufferedOutputStream.flush();
        socket.shutdownOutput();
        System.out.println("图片已发送");
        //接收服务端消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //over
        bufferedReader.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}
