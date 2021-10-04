package com.exercise.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Test3Client {
    public static void main(String[] args) throws IOException {
        //获取图片名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要下载的图片名：");
        String input = scanner.next();
        //链接服务器，发送名称
        Socket socket = new Socket(InetAddress.getByName("172.16.188.74"), 9999);
        BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufWriter.write(input);
        bufWriter.flush();
        socket.shutdownOutput();
        //接收服务器返回，并保存
        //输入流
        BufferedInputStream bufInputStream = new BufferedInputStream(socket.getInputStream());
        //输出流
        String downLoadPath = "C:\\Java\\Project\\Java_IDEA\\Java_base\\src\\com\\exercise\\net\\download.png";
        BufferedOutputStream bufOutputStream = new BufferedOutputStream(new FileOutputStream(downLoadPath));
        //转
        int length;
        byte[] data = new byte[1024];
        while ((length = bufInputStream.read(data)) != -1){
            bufOutputStream.write(data,0,length);
        }
        bufOutputStream.flush();
        //over
        System.out.println("Successfully download");
        bufOutputStream.close();
        bufInputStream.close();
        bufWriter.close();
        socket.close();
    }
}
