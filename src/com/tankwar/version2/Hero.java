package com.tankwar.version2;

public class Hero extends Tank {
    //定义一个shot对象
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }
    public void shotEnemyTank(){
        //创建Shot对象，根据当前Hero对象的位置和方向来创建
        switch (getDirect()){
            case 0:
                shot = new Shot(getX() + 20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX() +50,getY() + 30,1);
                break;
            case 2:
                shot = new Shot(getX() + 20,getY() + 60,2);
                break;
            case 3:
                shot = new Shot(getX() - 10,getY() + 30,3);
                break;
        }
        new Thread(shot).start();
    }
}
