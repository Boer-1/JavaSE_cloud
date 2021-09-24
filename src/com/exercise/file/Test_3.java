package com.exercise.file;

import java.io.*;
import java.util.Properties;

public class Test_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.setProperty("name","Ton");
        properties.setProperty("age","5");
        properties.setProperty("color","red");
        properties.store(new FileWriter("C:\\Users\\依格\\Desktop\\repository\\tiger.properties"),"tiger");

        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");

        Tiger tiger = new Tiger(name,age,color);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\依格\\Desktop\\repository\\tiger.dat"));
        objectOutputStream.writeObject(tiger);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\依格\\Desktop\\repository\\tiger.dat"));
        Object o = objectInputStream.readObject();
        Tiger tiger1 = (Tiger) o;
        System.out.println(tiger1.getName());
    }
}
class Tiger implements Serializable {
    private String name;
    private String age;
    private String color;

    public Tiger(String name, String age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }
}
