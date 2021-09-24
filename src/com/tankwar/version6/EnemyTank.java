package com.tankwar.version6;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    {
        setSpeed(3);
    }
    //在敌人坦克类，使用Vector保存多个shot
    Vector<Shot> shots = new Vector<>();
    //用来装敌人坦克，遍历用，值从MyPanel获取
    Vector<EnemyTank> enemyTanks = new Vector<>();


    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //根据坐标，判断是否重叠接触
    public boolean isTouch(){
        for (EnemyTank enemyTank : enemyTanks){
            if(enemyTank != this){
                switch (this.getDirect()){
                    //0123,上右下左
                    case 0:
                        if(enemyTank.getDirect() == 0||enemyTank.getDirect() == 2){
                            if(this.getX() > enemyTank.getX() - 40 && this.getX() < enemyTank.getX() + 40
                            &&this.getY() > enemyTank.getY() && this.getY() < enemyTank.getY() + 60){
                                return true;
                            }
                        }else if(enemyTank.getDirect() == 1||enemyTank.getDirect() == 3){
                            if(this.getX() > enemyTank.getX() - 40 && this.getX() < enemyTank.getX() + 60
                                    &&this.getY() > enemyTank.getY() && this.getY() < enemyTank.getY() + 40){
                                return true;
                            }
                        }
                        break;
                    case 2:
                        if(enemyTank.getDirect() == 0||enemyTank.getDirect() == 2){
                            if(this.getX() > enemyTank.getX() - 40 && this.getX() < enemyTank.getX() + 40
                                    &&this.getY() > enemyTank.getY() - 60 && this.getY() < enemyTank.getY()){
                                return true;
                            }
                        }else if(enemyTank.getDirect() == 1||enemyTank.getDirect() == 3){
                            if(this.getX() > enemyTank.getX() - 40 && this.getX() < enemyTank.getX() + 60
                                    &&this.getY() > enemyTank.getY() - 60 && this.getY() < enemyTank.getY()){
                                return true;
                            }
                        }
                        break;
                    case 1:
                        if(enemyTank.getDirect() == 0||enemyTank.getDirect() == 2){
                            if(this.getX() > enemyTank.getX() - 60 && this.getX() < enemyTank.getX()
                                    &&this.getY() > enemyTank.getY() - 40 && this.getY() < enemyTank.getY() + 60){
                                return true;
                            }
                        }else if(enemyTank.getDirect() == 1||enemyTank.getDirect() == 3){
                            if(this.getX() > enemyTank.getX() - 60 && this.getX() < enemyTank.getX()
                                    &&this.getY() > enemyTank.getY() - 40 && this.getY() < enemyTank.getY() + 40){
                                return true;
                            }
                        }
                        break;
                    case 3:
                        if(enemyTank.getDirect() == 0||enemyTank.getDirect() == 2){
                            if(this.getX() > enemyTank.getX() && this.getX() < enemyTank.getX() + 40
                                    &&this.getY() > enemyTank.getY() - 40 && this.getY() < enemyTank.getY() + 60){
                                return true;
                            }
                        }else if(enemyTank.getDirect() == 1||enemyTank.getDirect() == 3){
                            if(this.getX() > enemyTank.getX() && this.getX() < enemyTank.getX() + 60
                                    &&this.getY() > enemyTank.getY() - 40 && this.getY() < enemyTank.getY() + 40){
                                return true;
                            }
                        }
                        break;
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (true){
            //获取一个随机数
            int random = (int)(Math.random() * 100);

            switch (getDirect()){//direction 0上1右2下3左
                case 0:
                    for (int i = 0;i < random;i++){
                        if(!isTouch()){
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 1:
                    for (int i = 0;i < random;i++) {
                        if(!isTouch()){
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0;i < random;i++) {
                        if(!isTouch()){
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0;i < random;i++) {
                        if(!isTouch()){
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //改变坦克方向
            setDirect(random/25);
            //写并发，一定考虑线程结束情况
            if(!isLive) break;
        }
    }
}
