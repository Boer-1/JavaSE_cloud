package com.tankwar.version4;

import javax.swing.*;

//限制活动区域，敌方坦克可随机移动（做成线程）,打一发
public class Game_v4 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game_v4 game_v1 = new Game_v4();

    }
    public Game_v4(){
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
