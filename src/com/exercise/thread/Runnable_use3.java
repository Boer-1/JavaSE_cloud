package com.exercise.thread;

public class Runnable_use3 {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }
}
class SellTicket implements Runnable {
    private static int tickets = 100;
    @Override
    public void run() {
        while (true){
            synchronized (SellTicket.class){
                if(tickets <= 0){
                    System.out.println("no more ticket");
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println(Thread.currentThread().getName()+ "===>" + --tickets);
            }
        }
    }
}
