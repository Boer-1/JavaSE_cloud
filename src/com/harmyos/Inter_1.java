package com.harmyos;

public interface Inter_1 {
    void speak();
    default void talk(){
        System.out.println("interface==>talk");
    }
}
