package com.homework;

public class TV {
    private boolean power;
    private int channel;
    private int volume;

    public TV(boolean power, int channel, int volume) {
        this.power = power;
        this.channel = channel;
        this.volume = volume;
    }

    /**
     * power 电源开关
     * channel 频道
     * volume 音量
     */

    public void powerControl(boolean tag){
        this.power = tag;
    }
    public void channelChange(int channel){
        this.channel = channel;
    }
    public void volumeAdjust(int volume){
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "TV{" +
                "power=" + power +
                ", channel=" + channel +
                ", volume=" + volume +
                '}';
    }
}
