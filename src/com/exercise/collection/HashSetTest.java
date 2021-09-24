package com.exercise.collection;

import java.util.HashSet;
import java.util.Objects;

import static java.util.Objects.hash;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("Tom",20));
        hashSet.add(new Employee("Jack",30));
        hashSet.add(new Employee("Jack",30));
        System.out.println(hashSet.size());

    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
            //parameter should be Object
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.age == employee.age && Objects.equals(name, employee.name);
    }

    public int hashCode(){
        return hash(name,age);
    }

}
