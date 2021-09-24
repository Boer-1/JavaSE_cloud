package com.exercise.thread;

public class Runnable_use2 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread proxy1 = new Thread(thread1);
        Thread proxy2 = new Thread(thread2);
        proxy1.start();
        proxy2.start();
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        for(int i =0 ;i < 5;i ++){
            System.out.println(Thread.currentThread().getName() +
                    "====>" + i + "hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread2 implements Runnable{
    @Override
    public void run() {
        for(int i =0 ;i < 10;i ++){
            System.out.println(Thread.currentThread().getName() +
                    "====>" + i + "hello,world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}