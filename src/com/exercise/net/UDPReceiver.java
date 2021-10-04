package com.exercise.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //准备数据报接收
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //接收，会阻塞
        System.out.println("接收中···");
        datagramSocket.receive(datagramPacket);
        //接收到后，拆包
        byte[] data = datagramPacket.getData();
        System.out.println("得到了···");
        System.out.println(new String(data,0,datagramPacket.getLength()));

        //回消息
        byte[] r = "好的，明天见".getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket
                (r, r.length, InetAddress.getByName("172.16.188.74"), 8888);
        datagramSocket.send(datagramPacket1);
        System.out.println("发送了···");

        //over
        datagramSocket.close();
    }
}
