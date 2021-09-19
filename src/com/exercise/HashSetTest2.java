package com.exercise;

import java.util.HashSet;
import java.util.Objects;

public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Worker tom = new Worker("Tom", 2000, new Mydate(2000, 1, 1));
        Worker tom1 = new Worker("Tom", 4000, new Mydate(2000, 1, 1));
        Worker jack = new Worker("Jack", 2000, new Mydate(2010, 1, 1));
        hashSet.add(tom);
        hashSet.add(tom1);
        hashSet.add(jack);
        System.out.println(hashSet.size());
    }
}
class Worker{
    private String name;
    private double sal;
    private Mydate birday;

    public Worker(String name, double sal, Mydate birday) {
        this.name = name;
        this.sal = sal;
        this.birday = birday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) && Objects.equals(birday, worker.birday);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(name, birday.getDay(),birday.getMonth(),birday.getYear());
        return Objects.hash(name, birday);
    }
}
class Mydate{
    private int year;
    private int month;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydate mydate = (Mydate) o;
        return year == mydate.year && month == mydate.month && day == mydate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}