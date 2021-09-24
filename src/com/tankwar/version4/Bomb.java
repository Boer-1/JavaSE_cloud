package com.tankwar.version4;

public class Bomb {
    int x,y;//coordinate
    int life = 9;//the life circle of bomb
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDown(){
        if(life > 0){
            life--;
        }else {
            isLive = false;
        }
    }
}
