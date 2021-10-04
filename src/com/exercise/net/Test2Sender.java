package com.exercise.net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Test2Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8866);
        System.out.println("Question come here");
        Scanner scanner = new Scanner(System.in);
        byte[] bytes1 = scanner.next().getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("172.16.188.74"), 8888);
        datagramSocket.send(datagramPacket);
        //接收
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket1);
        System.out.println(new String(datagramPacket1.getData(),0,datagramPacket1.getLength()));
        //over
        System.out.println("Sender···");
        datagramSocket.close();
    }
}
