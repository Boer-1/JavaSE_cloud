package com.exercise.net;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    @Test
    public void getLocalHost() throws UnknownHostException {
        //获取本机InetAddress对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
    @Test
    public void getByName() throws UnknownHostException {
        //根据指定主机名或域名获取IP地址对象
        InetAddress byName = InetAddress.getByName("LAPTOP-9RKA4FQR");
        System.out.println(byName);
        InetAddress domain_name  = InetAddress.getByName("www.baidu.com");
        System.out.println(domain_name);
    }
    @Test
    public void getHostName() throws UnknownHostException {
        //获取InetAddress对象的主机名
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        System.out.println(hostName);
    }
    @Test
    public void getHostAddress() throws UnknownHostException {
        //获取InetAddress对象的地址
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);
    }
}
