package com.exercise.thread;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Loop loop = new Loop();
        Control control = new Control(loop);
        loop.start();
        control.start();
    }
}
class Loop extends Thread{
    private  boolean tag = true;
    @Override
    public void run() {
        while (tag){
            try {
                Thread.sleep(1000);
                System.out.println("Loop print==>" + (int)(Math.random() * 100 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setTag(boolean tag) {
        this.tag = tag;
    }
}
class Control extends Thread{
    private Loop loop;
    private Scanner scanner = new Scanner(System.in);
    public Control(Loop loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("press q to exit");
            char c = scanner.next().toUpperCase().charAt(0);
            if(c == 'Q'){
                loop.setTag(false);
                System.out.println("exit!!!");
                break;
            }
        }
    }
}