package com.exercise.thread;

public class Runnable_use {
    public static void main(String[] args) {
        Prompter prompter = new Prompter();
        //prompter.start();//don't effect
        //使用实现Runnable接口的方式实现：代理
        Thread thread = new Thread(prompter);
        thread.start();
    }
}
class Prompter implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()
                    +"==>"+ ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 20) break;
        }

    }
}