package com.exercise.file;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "C:\\Users\\依格\\Desktop\\repository\\ObjectOutputStream_.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(sourceFilePath));
        /*
                objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeDouble(1.123);
            objectOutputStream.writeUTF("test");
            objectOutputStream.writeObject(new Dog("cute"));

         */
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        System.out.println(objectInputStream.readObject());
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
    }
}