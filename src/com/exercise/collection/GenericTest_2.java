package com.exercise.collection;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericTest_2 {
    public static void main(String[] args) {
        Employee_GT thomas2 = new Employee_GT("Thomas", 5000, new Birthday(2016, 4, 1));
        Employee_GT thomas3 = new Employee_GT("Thomas", 5000, new Birthday(2016, 5, 1));
        Employee_GT tom = new Employee_GT("Tom", 2000, new Birthday(2000, 1, 1));
        Employee_GT lauren = new Employee_GT("Lauren", 6000, new Birthday(2020, 3, 1));
        Employee_GT jack = new Employee_GT("Jack", 4000, new Birthday(2010, 2, 1));
        Employee_GT thomas = new Employee_GT("Thomas", 5000, new Birthday(2015, 4, 1));
        ArrayList<Employee_GT> employee_gts = new ArrayList<>();
        employee_gts.add(tom);
        employee_gts.add(jack);
        employee_gts.add(lauren);
        employee_gts.add(thomas);
        employee_gts.add(thomas2);
        employee_gts.add(thomas3);
        employee_gts.sort(new Comparator<Employee_GT>() {
            @Override
            public int compare(Employee_GT a, Employee_GT b) {
                //先按照name排序，如果name相同，则按生日日期的先后排序
                int gapName = a.getName().compareTo(b.getName());
                if(gapName != 0) return gapName;
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });
        System.out.println(employee_gts);
    }
}



class Birthday implements Comparable<Birthday>{
    private int year;
    private int month;
    private int day;

    public Birthday(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public String toString() {
        return year + "~" + month + "~" + day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Birthday o) {
            int gapYear = year - o.getYear();
            int gapMonth = month - o.getMonth();
            int gapDay = day - o.getDay();
            if(gapYear == 0){
                if (gapMonth == 0) {
                    return gapDay;
                }return gapMonth;
            }return gapYear;
        }
}
class Employee_GT{
    private String name;
    private double sal;
    private Birthday birthday;

    public Employee_GT(String name, double sal, Birthday birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nname:" + name +
                "\tsal:" + sal +
                "\tbirthday:" + birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }
}
