package com.exercise.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{
    private MyPanel mypanel = null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle(){
        mypanel = new MyPanel();
        this.add(mypanel);
        this.setSize(300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("I am drawing");
        //drawOval
        g.drawOval(10,10,200,200);
        //drawLine
        g.drawLine(10,10,210,10);
        g.drawLine(210,10,210,210);
        //drawRectangle
        g.drawRect(110,10,100,100);
        //fill Rect
        g.setColor(Color.PINK);
        g.fillRect(110,110,50,50);
        //fill Oval
        g.fillOval(60,60,50,50);
        //drawImage
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/beauty.jpeg"));
        g.drawImage(image,160,10,50,100,this);
        //drawString
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("隶书",Font.BOLD,20));
        g.drawString("~drawing~",10,110);

    }
}