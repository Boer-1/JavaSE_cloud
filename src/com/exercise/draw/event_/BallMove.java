package com.exercise.draw.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//实现监听键盘事件接口
public class BallMove extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        //窗口JFrame对象可以监听键盘事件，即可以监听到 面板发生的键盘事件
        this.addKeyListener(mp);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MyPanel extends JPanel  implements KeyListener{
    //to get the little ball to move,set its coordinates as a variable
    int x;
    int y;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //KeyEvent.VK_DOWN Corresponding to the downward arrow
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y += 3;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y -= 3;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x += 3;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x -= 3;
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}