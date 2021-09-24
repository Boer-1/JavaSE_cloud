package com.exercise.thread;

public class Thread_use {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();
        for(int i = 0;i < 100;i++){
            System.out.println("========>" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread{
    int times = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("Loading ~~~" + ++times + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) break;
        }
    }
}