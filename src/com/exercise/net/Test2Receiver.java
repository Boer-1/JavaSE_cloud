package com.exercise.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test2Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        System.out.println("Receiver等待中···");
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();

        if("四大名著是哪些".equals(new String(data,0,datagramPacket.getLength()))){
            byte[] bytes1 = "《红楼梦》···".getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("172.16.188.74"), 8866);
            datagramSocket.send(datagramPacket1);
        }else {
            byte[] bytes1 = "what???".getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("172.16.188.74"), 8866);
            datagramSocket.send(datagramPacket1);
        }
        //over
        System.out.println("Receiver关闭···");
        datagramSocket.close();
    }
}
