package com.tankwar.version2;

public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true;
    /**
     * x 子弹x坐标
     * y 子弹y坐标
     * direct 子弹方向
     * speed 子弹速度
     * isLive 子弹存在
     */
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct){
                case 0:
                    y -= speed; //direction 0上1右2下3左
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println("子弹坐标：" + x + "~" + y);
            if(!(x >= 0&& x <= 1000&& y >= 0&&y <= 750)){
                isLive = false;
                break;
            }
        }
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }
}
