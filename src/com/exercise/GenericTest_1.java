package com.exercise;

import java.util.*;

public class GenericTest_1 {
    public static void main(String[] args) {
        Student tom = new Student("Tom", 10);
        Student jack = new Student("Jack", 20);
        Student smith = new Student("Smith", 25);
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(tom);
        hashSet.add(jack);
        hashSet.add(smith);
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put(tom.getName(),tom);
        hashMap.put(jack.getName(),jack);
        hashMap.put(smith.getName(),smith);
        //enhanced for loop
        for(Student student : hashSet){
            System.out.println(student.getName());
        }
        //the iterator loop
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}