package com.exercise.draw;

import javax.swing.*;
import java.awt.*;

public class DrawTank extends JFrame{
    private MyPanel_Tank myPanel_tank = null;
    public static void main(String[] args) {
        new DrawTank();
    }
    public DrawTank(){
        myPanel_tank = new MyPanel_Tank();
        this.add(myPanel_tank);
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
class MyPanel_Tank extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillRect(50,100,15,50);
        g.fillRect(90,100,15,50);
        g.fillRect(65,108,25,30);
        g.fillRect(77,83,2,40);
        g.setColor(Color.BLACK);
        g.fillOval(65,110,25,25);

    }
}

