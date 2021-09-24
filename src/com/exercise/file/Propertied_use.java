package com.exercise.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Propertied_use {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\依格\\Desktop\\repository\\local.properties"));
        properties.list(System.out);
        //读取
        String ip = properties.getProperty("ip");
        System.out.println(ip);
        //创建
        Properties properties1 = new Properties();
        //修改
        properties1.setProperty("name","Tom");
        properties1.setProperty("phone","1384626");
        //写入
        properties1.store(new FileWriter("C:\\Users\\依格\\Desktop\\repository\\infor.properties"),"user Information");
        properties1.setProperty("name","Lauren");
        properties1.store(new FileWriter("C:\\Users\\依格\\Desktop\\repository\\infor.properties"),"user Information");

    }
}
