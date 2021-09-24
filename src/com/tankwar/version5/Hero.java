package com.tankwar.version5;

import java.util.Vector;

public class Hero extends Tank {
    //定义一个shot对象
//    Shot shot = null;
    //Vector
    Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }
    public void shotEnemyTank(){
        //同时最多发射5颗
        if(shots.size() >=5)    return;
        //创建Shot对象，根据当前Hero对象的位置和方向来创建
        switch (getDirect()){
            case 0:
                shots.add(new Shot(getX() + 20,getY(),0));
                break;
            case 1:
                shots.add(new Shot(getX() +50,getY() + 30,1));
                break;
            case 2:
                shots.add(new Shot(getX() + 20,getY() + 60,2));
                break;
            case 3:
                shots.add(new Shot(getX() - 10,getY() + 30,3));
                break;
        }
//        new Thread(shot).start();
        for(Shot shot :shots){
            new Thread(shot).start();
        }
    }
}
