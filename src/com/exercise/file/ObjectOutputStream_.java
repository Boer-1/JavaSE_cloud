package com.exercise.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) {
        String targetFilePath = "C:\\Users\\依格\\Desktop\\repository\\ObjectOutputStream_.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(targetFilePath));
            objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeDouble(1.123);
            objectOutputStream.writeUTF("test");
            objectOutputStream.writeObject(new Dog("cute"));
            objectOutputStream.writeObject(new Cat("kedie"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

