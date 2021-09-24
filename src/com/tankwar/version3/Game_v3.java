package com.tankwar.version3;

import javax.swing.*;

//运用线程，可发射子弹
public class Game_v3 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game_v3 game_v1 = new Game_v3();

    }
    public Game_v3(){
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
