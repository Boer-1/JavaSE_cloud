package com.exercise.file;

import java.io.BufferedReader;

public class Modifier_Design_Mode {
    public static void main(String[] args) {
        FileReader_ fileReader_ = new FileReader_();
        StringReader_ stringReader_ = new StringReader_();

        //分别接受两个节点流
        BufferedReader_ bufferedReader = new BufferedReader_(fileReader_);
        bufferedReader.readFiles(2);
        bufferedReader = new BufferedReader_(stringReader_);
        bufferedReader.readFiles(2);
        //自己的方法
        bufferedReader.readFile();
    }
}
abstract class Reader_{//抽象类
    public abstract void readFile();

}
class FileReader_ extends Reader_{//
    public void readFile(){
        System.out.println("FileReader_ ====> readFile");
    }
}
class StringReader_ extends Reader_{//节点流
    public void readFile(){
        System.out.println("StringReader_ ====> readFile");
    }
}
class BufferedReader_ extends Reader_{//处理流
    private Reader_ reader_ ;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    public BufferedReader_(){}

    @Override
    public void readFile() {//可自己定义方法
        System.out.println("BufferedReader ====> readFile");
    }
    public void readFiles(int num){//也可处理接受对象的方法
        for(int i =0 ;i < num;i++){
            reader_.readFile();
        }
    }
}