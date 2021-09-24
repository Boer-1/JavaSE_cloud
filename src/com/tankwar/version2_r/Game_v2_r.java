package com.tankwar.version2_r;

import javax.swing.*;

public class Game_v2_r extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game_v2_r game_v1 = new Game_v2_r();

    }
    public Game_v2_r(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
