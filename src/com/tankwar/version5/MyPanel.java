package com.tankwar.version5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //define my tank
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    //定义图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    Image image4 = null;
    //敌方坦克数量
    int enemyTankSize = 5;


    public MyPanel(){
        //Initialize our tank
        hero = new Hero(700,500);
        hero.setSpeed(5);
        //Initialize enemyTanks
        for(int i = 0;i < enemyTankSize;i++){
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            new Thread(enemyTank).start();
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/tankwar/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/tankwar/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/tankwar/bomb_3.gif"));
        image4 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/com/tankwar/death.png"));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        //drawTank 封装方法
        //draw our tanks
        if(hero.isLive){
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
            //画出Hero射击的子弹
            drawShots(hero.shots, g);
        }else {
            g.drawImage(image4,hero.getX() - 30,hero.getY()-30,110,110,this);
            System.out.println("==========game over===========");
        }

        //如果bombs集合中有对象，就画出
        for(int i = 0;i < bombs.size();i++){
            //取出炸弹
            Bomb bomb = bombs.get(i);
            if(bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life > 3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果bomb life 为0 ，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb );
            }
        }

        //draw EnemyTank 遍历Vector
        if(enemyTanks.size() != 0){
            for(EnemyTank enemyTank : enemyTanks){
                if(enemyTank.isLive) {//当敌人坦克是活的
                    drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                    enemyTank.limit();
                    //画出enemyTank的全部子弹
                    drawShots(enemyTank.shots, g);
                }else {
                    enemyTanks.remove(enemyTank);
                }
            }
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
    public void hitTank(Shot s, Tank tank){
        //通过判断s是否在enemyTank的矩形范围内来判断是否击中
        switch (tank.getDirect()){
            case 0://enemyTank向上向下
            case 2:
                if(s.x > tank.getX() && s.x < tank.getX() + 40
                &&s.y > tank.getY() && s.y <tank.getY() +60){
                    s.isLive = false;
                    tank.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if(s.x > tank.getX() && s.x < tank.getX() + 60
                &&s.y > tank.getY() && s.y < tank.getY() + 40){
                    s.isLive = false;
                    tank.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
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
        hero.limit();
        //if the user press j,just shot!
        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }
    public void drawShots(Vector<Shot> shots,Graphics g){
        for (int i = 0; i < shots.size(); i++) {
            //取出子弹
            Shot shot = shots.get(i);
            //绘制
            if (shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 2, 2, false);
            } else {
                shots.remove(shot);
            }
        }
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
            //判断是否击中了敌方坦克
            for(Shot shot : hero.shots) {
                //遍历敌方坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
            //判断是否击中了我方坦克
            for(EnemyTank enemyTank :enemyTanks){
                for(Shot shot : enemyTank.shots) {
                    hitTank(shot,hero);
                }
            }


            //判断敌方子弹是否进程结束，结束则再添加一枚
            for(EnemyTank enemyTank : enemyTanks){
                if(enemyTank.shots.size() < 2){
                    switch (enemyTank.getDirect()){
                        case 0:
                            enemyTank.shots.add(new Shot(enemyTank.getX() + 20,enemyTank.getY(),0));
                            break;
                        case 1:
                            enemyTank.shots.add(new Shot(enemyTank.getX() +50,enemyTank.getY() + 30,1));
                            break;
                        case 2:
                            enemyTank.shots.add(new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60,2));
                            break;
                        case 3:
                            enemyTank.shots.add(new Shot(enemyTank.getX() - 10,enemyTank.getY() + 30,3));
                            break;
                    }

                    for(Shot shot : enemyTank.shots){
                        new Thread(shot).start();
                    }
                }
            }
            //重绘
            this.repaint();
        }

    }
}
