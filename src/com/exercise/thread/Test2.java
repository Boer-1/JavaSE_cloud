package com.exercise.thread;

public class Test2 {
    public static void main(String[] args) {
        Depositor depositor = new Depositor();
        new Thread(depositor).start();
        new Thread(depositor).start();
    }
}
class Depositor implements Runnable{
    private static int savings = 10000;
    private int consumption = 1000;
    @Override
    public void run() {
        while (true){
             try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                if(savings <= 0){
                    System.out.println("no more money");
                    break;
                }
                savings -= consumption;
                System.out.println(Thread.currentThread().getName() +
                        " take away " + consumption + " remaining$ " + savings);
            }
        }
    }
}