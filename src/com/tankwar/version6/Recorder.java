package com.tankwar.version6;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class Recorder {
    //击毁敌方坦克数
    private static int defeatEnemyNum = 0;
    //遍历用
    private static Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义IO对象
    private static String recordFile = "C:\\Java\\Project\\Java_IDEA\\Java_base\\src\\recorder.txt";
//    private static BufferedWriter bufferedWriter = null;
    private static Properties properties = new Properties();
    public static void writeCordToFile(){
        try {
            properties.setProperty("defeatEnemyNum",defeatEnemyNum+"");
            //writeEnemyPosition
            writeEnemyPosition();
            properties.store(new FileWriter(recordFile),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取文件，返回enemyTanks Vector,
    public static Vector<EnemyTank> loadPreInfo(){
        try {
            int x,y,dir;
            String s;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(recordFile));
            try {
                while ((s = bufferedReader.readLine()) != null){
                    String[] split = s.split(",");
                    if(split.length == 2){
                        x = Integer.parseInt(split[0]);
                        String[] split1 = split[1].split("=");
                        y = Integer.parseInt(split1[0]);
                        dir = Integer.parseInt(split1[1]);
                        //new EnemyTank
                        EnemyTank enemyTank = new EnemyTank(x,y);
                        enemyTank.setDirect(dir);
                        enemyTanks.add(enemyTank);
                    }else if(split[0].charAt(0) != '#'){
                        String[] split2 = split[0].split("=");
                        setDefeatEnemyNum(Integer.parseInt(split2[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return enemyTanks;
    }
    public static void writeEnemyPosition(){
        for(EnemyTank enemyTank :enemyTanks){
            int x = enemyTank.getX();
            int y = enemyTank.getY();
            int dir = enemyTank.getDirect();
            properties.setProperty(x+","+y,dir +"");
        }
    }
    public static int getDefeatEnemyNum() {
        return defeatEnemyNum;
    }

    public static void setDefeatEnemyNum(int defeatEnemyNum) {
        Recorder.defeatEnemyNum = defeatEnemyNum;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void addNum(){
        defeatEnemyNum++;
    }
}
