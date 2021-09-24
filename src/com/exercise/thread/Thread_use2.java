package com.exercise.thread;

public class Thread_use2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SubThread());
        thread.setName("SubThread");
        for (int i = 1; i <= 10;i++){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " ==> hi" + "$" + i);
            if(i == 5){
                thread.start();
                thread.join();
            }
        }
    }
}
class SubThread implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " ==> hello" + "$" + ++count);
            if(count == 10)break;
        }
    }
}