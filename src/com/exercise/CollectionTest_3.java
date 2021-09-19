package com.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionTest_3 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put("Jack",650);
        hashMap.put("Tom",1200);
        hashMap.put("Smith",2900);
        hashMap.put("Jack",2600);
        System.out.println(hashMap);

        Set entrySet = hashMap.entrySet();
        for (Object o :entrySet) {
            Map.Entry entry = (Map.Entry) o;
            //各员工加薪100

            hashMap.put(entry.getKey(),(Integer)entry.getValue() + 100);
            //遍历集合中所有员工，工资
            System.out.println(entry.getKey() + "~" + entry.getValue());
        }
        System.out.println(hashMap);


        Set keySet = hashMap.keySet();
        for(Object obj: keySet){
            hashMap.put(obj,(Integer)hashMap.get(obj) + 100);
        }
        System.out.println(hashMap);
    }
}
