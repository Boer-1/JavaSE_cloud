package com.harmyos;

public class Implementation implements Inter_1,Inter_2{

    @Override
    public void speak() {
        System.out.println("speak");
    }

    @Override
    public void talk() {
        System.out.println("Implementation==>talk");
    }
}
