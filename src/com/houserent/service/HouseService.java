package com.houserent.service;

import com.houserent.domain.House;
import com.houserent.utils.Input;

public class HouseService {
    private House[] houses;
    private int number = 1;
    private Input input = new Input();

    public HouseService(int size){
        houses = new House[size];
        //houses[0] = new House(1,"Tom","13838855665","海淀",2000,"not rent");
    }

    public void findHouse(int label){
        for (House house : houses) {
            if (house.getId() == label) {
                System.out.println("id为" + label + "的房屋信息为：");
                System.out.println(house.toString());
                break;
            }
        }
    }
    public House updateHouse(int label){
        for (House house : houses) {
            if (house.getId() == label) {
                return house;
            }
        }
        return null;
    }
    public int del_accessible(){
        int del_id = input.i_getInt();
        //don't want more:-1
        if(del_id == -1) return -1;
        //find:del_id
        for(House per:houses){
            if(per.getId() == del_id){
                return del_id;
            }
        }
        //error:-2
        return -2;
    }
    public void delHouse(int label){
        for(int i = 0;i < houses.length;i++){
            if(houses[i].getId() == label){
                //后边覆盖前边
                if (houses.length - 1 - i >= 0) System.arraycopy(houses, i + 1, houses, i, houses.length - 1 - i);
                houses[number-- - 2] = null;
            }
        }
    }

    public void addHouse(House house){
            house.setId(number);
            houses[number++ - 1] = house;

    }
    public boolean add_accessible(){
        return (number <= getHouses().length);
    }
    public House getInfo(){
        System.out.print("name:");
        String name = input.i_str();
        System.out.print("tel:");
        String tel = input.i_str();
        System.out.print("add:");
        String add = input.i_str();
        System.out.print("rent:");
        int rent = input.i_rent();
        System.out.print("state:");
        String state = input.i_str();
        return new House(0, name, tel, add, rent, state);

    }

    public House[] getHouses(){
        return houses;
    }


    public void setNumber(int number) {
        this.number = number;
    }

}
