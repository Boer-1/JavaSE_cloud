package com.exercise.file;

import java.io.Serializable;

public class Dog implements Serializable {
    private String name;
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Cat extends Dog{

    public Cat(String name) {
        super(name);
    }
}