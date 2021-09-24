package com.homework;

public class TestPerson {
    public static void main(String[] args) {
        //无参
        Person personUndefined = new Person();
        personUndefined.setName("Tom");
        personUndefined.setAge(20);
        personUndefined.setSex("male"   );
        personUndefined.setNation("America");
        //有参
        Person personInitialized = new Person("Lauren", 25, "female", "England");
        //输出信息(两种方式)
        System.out.println("personUndefined Information");
        System.out.println(personUndefined);

        System.out.println("personInitialized Information:");
        System.out.println("name: " + personInitialized.getName());
        System.out.println("age: " + personInitialized.getAge());
        System.out.println("sex: " + personInitialized.getSex());
        System.out.println("nation: " + personInitialized.getNation());
    }
}
