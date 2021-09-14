package com.houserent.utils;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    //将123456.456输出成123,456.456
    public void formatPrint(){
        String price = "123456.456";
        StringBuffer stringBuffer = new StringBuffer(price);
        for(int i = stringBuffer.lastIndexOf(".") - 3;i > 0;i -= 3){
            stringBuffer.insert(i, ",");
        }
        System.out.println(stringBuffer);
    }

    //选择功能用
    public int i_choice(){
        do {
            int temp = scanner.nextInt();
            if (temp >= 1 && temp <= 6) {
                return temp;
            } else {
                System.out.println("Error input,try again~");
            }
        }while (true);
    }
    //接受字符串用
    public String i_str(){
        do {
            String temp = scanner.next();
            if(temp != null){
                return temp;
            }else {
                System.out.println("Error input,try again~");
            }
        }while(true);
    }
    //接受一个数
    public int i_rent(){
        do {
            int temp = scanner.nextInt();
            if(temp <= 0){
                System.out.println("Error input,try again~");
            }else return temp;
        }while(true);
    }
    public int i_getInt(){
        return scanner.nextInt();
    }
    public boolean i_firm(){
        do {
            String temp = scanner.next();
            if (temp.equals("y")) {
                return true;
            } else if(temp.equals("n")){
                return false;
            }else{
                System.out.println("Error input,try again~");
            }
        }while (true);
    }
    public String i_getstr(){
        return scanner.next();
    }

}
