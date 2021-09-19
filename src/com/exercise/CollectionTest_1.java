package com.exercise;

import java.util.ArrayList;

public class CollectionTest_1 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        for(int i = arrayList.size() - 1;i >= 0;i--){
            News news = (News) arrayList.get(i);
            if(news.getTitle().length() > 15){
                String newTitle = news.getTitle().substring(15) + "...";
                news.setTitle(newTitle);
                System.out.println(news);
            }

        }


    }
}
class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News$" + "title:" + title ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
