package com.tankwar.version5;

import javax.swing.*;
//打多发子弹，敌人也可攻击，我方允许毁灭
public class Game_v5 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game_v5 game_v1 = new Game_v5();

    }
    public Game_v5(){
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
