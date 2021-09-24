package com.exercise.collection;

import java.util.ArrayList;
import java.util.List;

public class listTest_2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book_("Dream of the red chamber","Xueqin,Cao",20));
        list.add(new Book_("The Romance of the three kingdoms","Guanzhong,Luo",50));
        list.add(new Book_("All Men Are Brothers","Naian,Shi",30));
        Book_.sort(list);
        for(Object book_ : list){
            System.out.println(book_);
        }


    }
}
class Book_{
    private String name;
    private String author;
    private double price;

    public Book_(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "\tprice: " + price +
                "\t\t\tauthor: " + author;
    }
    public static void sort(List list){
        boolean tag;
        for(int i = 0;i < list.size() - 1;i++){
            tag = true;
            for(int j = 0;j < list.size() - 1 - i;j++){
                if(((Book_)list.get(j)).getPrice() > ((Book_)list.get(j + 1)).getPrice()){
                    Object temp = list.get(j);
                    list.set(j,list.get(j +1));
                    list.set(j + 1,temp);
                    tag = false;
                }
            }
            if(tag) break;
        }
    }

    public double getPrice() {
        return price;
    }

}
