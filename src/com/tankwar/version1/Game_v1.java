package com.tankwar.version1;

import javax.swing.*;
//绘制坦克，可以移动
public class Game_v1 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game_v1 game_v1 = new Game_v1();

    }
    public Game_v1(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
