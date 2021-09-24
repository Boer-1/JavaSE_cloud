package com.tankwar.version5;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    {
        setSpeed(3);
    }
    //在敌人坦克类，使用Vector保存多个shot
    Vector<Shot> shots = new Vector<>();



    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true){
            //获取一个随机数
            int random = (int)(Math.random() * 100);

            switch (getDirect()){//direction 0上1右2下3左
                case 0:
                    for (int i = 0;i < random;i++){
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 1:
                    for (int i = 0;i < random;i++) {
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0;i < random;i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0;i < random;i++) {
                        moveLeft();
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
