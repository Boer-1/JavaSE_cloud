package com.tankwar.version6;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

//增加继续上局游戏功能
public class Game_v6 extends JFrame {
    MyPanel mp = null;
    static int model = 0;

    public static void main(String[] args) {
        System.out.println("1/0");
        //1:上局游戏
        //其他：新游戏
        Scanner scanner = new Scanner(System.in);
        String select = scanner.next();
        if(Integer.parseInt(select) == 1){
            model = 1;
        }
        Game_v6 game_v1 = new Game_v6();

    }
    public Game_v6(){
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.writeCordToFile();
                System.out.println("游戏正常退出，且存档~");
                System.exit(0);
            }
        });
    }
}
