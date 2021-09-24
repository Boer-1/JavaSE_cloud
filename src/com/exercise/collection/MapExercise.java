package com.exercise.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Employee_ tom = new Employee_("Tom", 20000, 1);
        Employee_ john = new Employee_("John", 2000, 2);
        Employee_ frank = new Employee_("Frank", 8000, 3);
        Employee_ smith = new Employee_("Smith", 40000, 4);

        Map hashMap = new HashMap();

        hashMap.put(tom.getId(), tom);
        hashMap.put(john.getId(), john);
        hashMap.put(frank.getId(), frank);
        hashMap.put(smith.getId(), smith);
        //keySet success
        System.out.println("====keySet Way====");
        Set keySet = hashMap.keySet();
        for (Object key :keySet) {
            Employee_ employee = (Employee_)hashMap.get(key);
            if(employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }
        System.out.println("====entrySet Way-I====");
        Set entrySet = hashMap.entrySet();
        for (Object o : entrySet){
            Map.Entry entry = (Map.Entry)o;
            Employee_ employee = (Employee_) entry.getValue();
            if (employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }
        System.out.println("====entrySet Way-iterator====");
        Set entrySet1 = hashMap.entrySet();
        Iterator iterator = entrySet1.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Employee_ employee = (Employee_) entry.getValue();
            if (employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }


    }
}
class Employee_{
    private String name;
    private int salary;
    private int id;

    public Employee_(String name, int salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id:" + id  +
                ", name:" + name +
                ", salary:" + salary ;
    }
}