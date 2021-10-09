package com.harmyos;

public interface Inter_2 {
    void speak();
    default void talk(){
        System.out.println("interface==>talk");
    }
}
