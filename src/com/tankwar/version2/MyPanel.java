package com.tankwar.version2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //define my tank
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel(){
        //Initialize our tank
        hero = new Hero(100,100);
        hero.setSpeed(5);
        //Initialize enemyTanks
        for(int i = 0;i < enemyTankSize;i++){
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        //drawTank 封装方法
        //draw our tanks
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        //画出Hero射击的子弹
        if(hero.shot != null && hero.shot.isLive){
            g.draw3DRect(hero.shot.x,hero.shot.y,2,2,false);
        }
        //draw EnemyTank 遍历Vector
        for(EnemyTank enemyTank : enemyTanks){
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
    }

    /**
     *
     * @param x 坦克左上角x坐标
     * @param y 坦克左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0://User tank
                g.setColor(Color.cyan);
                break;
            case 1://enemy tank
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向绘制坦克
        switch (direct){
            case 0://up
                g.fill3DRect(x,y,10,60,false);//left tire
                g.fill3DRect(x + 30,y,10,60,false);//right tire
                g.fill3DRect(x + 10,y + 10,20,40,false);//square lid
                g.fillOval(x + 10,y + 20,20,20);//round lid
                g.drawLine(x + 20,y + 30,x + 20,y);//gun
                break;
            case 1://right
                g.fill3DRect(x - 10,y + 10,60,10,false);//left tire
                g.fill3DRect(x - 10,y + 40,60,10,false);//right tire
                g.fill3DRect(x,y + 20,40,20,false);//square lid
                g.fillOval(x + 10,y + 20,20,20);//round lid
                g.drawLine(x + 20,y + 30,x + 50,y + 30);//gun
                break;
            case 2://down
                g.fill3DRect(x,y,10,60,false);//left tire
                g.fill3DRect(x + 30,y,10,60,false);//right tire
                g.fill3DRect(x + 10,y + 10,20,40,false);//square lid
                g.fillOval(x + 10,y + 20,20,20);//round lid
                g.drawLine(x + 20,y + 30,x + 20,y + 60);//gun
                break;
            case 3://left
                g.fill3DRect(x - 10,y + 10,60,10,false);//left tire
                g.fill3DRect(x - 10,y + 40,60,10,false);//right tire
                g.fill3DRect(x,y + 20,40,20,false);//square lid
                g.fillOval(x + 10,y + 20,20,20);//round lid
                g.drawLine(x + 20,y + 30,x - 10,y + 30);//gun
                break;
            default:
                System.out.println("It has not been handled as yet");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            hero.setDirect(2);
            hero.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            hero.setDirect(0);
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            hero.setDirect(1);
            hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            hero.setDirect(3);
            hero.moveLeft();
        }
        //if the user press j,just shot!
        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        //每隔100毫秒，重绘区域，子弹就移动
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
