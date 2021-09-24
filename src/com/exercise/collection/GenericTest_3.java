package com.exercise.collection;

import java.util.*;

public class GenericTest_3 {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1",new User(1,20,"Tom"));
        dao.save("2",new User(2,21,"Jack"));
        dao.save("3",new User(3,22,"Lauren"));
        System.out.println(dao.list());
    }
}
class DAO <T>{
    private Map<String,T> map = new HashMap<>();

    public void save(String id ,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id ,T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        Collection<T> values = map.values();
        return new ArrayList<T>(values);
    }
    public void delete(String id){
        map.remove(id);
    }
}
class User{
    private int id ;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                "}\n";
    }
}