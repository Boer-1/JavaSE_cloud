package com.exercise.net;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，指定端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //准备数据报
        byte[] data = "hello,明天吃火锅".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket
                (data, data.length, InetAddress.getByName("172.16.188.74"), 9999);
        //发送
        datagramSocket.send(datagramPacket);
        System.out.println("发送了···");

        //接收
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket1);
        byte[] data1 = datagramPacket1.getData();
        System.out.println(new String(data1,0,datagramPacket1.getLength()));
        //over
        datagramSocket.close();
    }
}
