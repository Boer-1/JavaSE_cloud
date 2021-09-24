package com.homework;

public class TestTV {
    public static void main(String[] args) {
        TV tv = new TV(false, 1, 20);
        System.out.println("出厂设置：\n" + tv);
        tv.channelChange(10);
        tv.powerControl(true);
        tv.volumeAdjust(50);
        System.out.println("调节后状态：\n" + tv);
    }
}
