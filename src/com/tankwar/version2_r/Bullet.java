package com.tankwar.version2_r;

import java.awt.*;

public class Bullet extends Thread{
    private int x;
    private int y;
    private int direction;
    private Graphics g;

    public Bullet(int x, int y, int direction, Graphics g) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.g = g;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;//tank direction 0上1右2下3左
    }
    @Override
    public void run() {
        while (true){
            if(x == 0||x ==1000||y ==0||y ==750)break;
            g.fillOval(x,y,2,2);
            if(direction == 0){
                y--;
            }else if (direction == 1){
                x++;
            }else if(direction == 2){
                y++;
            }else if (direction == 3){
                x--;
            }
        }
    }
}
