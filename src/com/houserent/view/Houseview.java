package com.houserent.view;

import com.houserent.domain.House;
import com.houserent.service.HouseService;
import com.houserent.utils.Input;

public class Houseview {
    private boolean loop = true;
    private HouseService houseService = new HouseService(2);
    private Input input = new Input();

    public void mainMenu(){
        do{
            System.out.println("=============房屋出租系统============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            //接受一个输入以进入功能
            System.out.println("Input your choice~");
            int select = input.i_choice();
            switch (select){
                case 1:
                    addHouse();
                    break;
                case 2:
                    findHouse();
                    break;
                case 3:
                    delHouse();
                    break;
                case 4:
                    updateInfo();
                    break;
                case 5:
                    C5_HouseList();
                    break;
                case 6:
                    houseService.setNumber(1);
                    System.out.println("see you~");
                    loop = false;
            }
        }while(loop);
    }
    public void updateInfo(){
        System.out.println("=============修改房屋信息============");
        System.out.println("input the id of house you want to update (-1 exit):");
        do {
            int up_judge = houseService.del_accessible();
            //no paired
            if(up_judge == -2){
                System.out.println("no house with this number,try again~");
            }else if(up_judge == -1){
                //user want to exit
                break;
            }
            /*
                            "\t"+name+
                "\t"+tel +
                "\t"+add +
                "\t"+rent +
                "\t"+state;
             */
            if(up_judge > 0){
                House transform = houseService.updateHouse(up_judge);
                System.out.print("name(" + transform.getName() +"):");
                String name = input.i_getstr();
                transform.setName(name);
                System.out.print("tel(" + transform.getTel() +"):");
                String tel = input.i_getstr();
                transform.setTel(tel);
                System.out.print("add(" + transform.getAdd() +"):");
                String add = input.i_getstr();
                transform.setAdd(add);
                System.out.print("rent(" + transform.getRent() +"):");
                int rent = input.i_getInt();
                transform.setRent(rent);
                System.out.print("state(" + transform.getState() +"):");
                String state = input.i_getstr();
                transform.setState(state);
                break;
            }
        }while (true);
    }
    public void findHouse(){
        System.out.println("=============查找房屋============");
        System.out.println("input the id of house you want to find (-1 exit):");
        do {
            int find_judge = houseService.del_accessible();
            //no paired
            if(find_judge == -2){
                System.out.println("no house with this number,try again~");
            }else if(find_judge == -1){
                //user want to exit
                break;
            }
            if(find_judge > 0){
                houseService.findHouse(find_judge);
                break;
            }
        }while (true);
    }
    public void delHouse(){
        System.out.println("=============删除房屋============");
        System.out.print("Input the id of house you want to delete (-1 exit)：");
        int del_judge;
        do {
            del_judge = houseService.del_accessible();
            if (del_judge == -2) {
                System.out.println("no house with this number,try again~");
            }
        } while (del_judge <= 0 && del_judge != -1);
        if(del_judge != -1){
            System.out.println("确认是否删除(input y/n)");
            boolean decide = input.i_firm();
            if(decide){
                houseService.delHouse(del_judge);
                System.out.println("=============删除成功============");
            }
        }

    }

    public void C5_HouseList(){
        System.out.println("=============房屋列表============");
        System.out.println("id\tname\ttel\t\tadd\t\trent\tstate");
        House[] houseArr= houseService.getHouses();
        for(House per:houseArr){
                if(per != null){
                    System.out.println(per.toString());
                }
        }
        System.out.println("=============显示完毕============");
    }
    public void addHouse(){
        System.out.println("=============添加房屋============");
        if(houseService.add_accessible()){
            House newHouse = houseService.getInfo();
            houseService.addHouse(newHouse);
            System.out.println("=============添加成功============");
        }else {
            System.out.println("There is no more space~");
        }



    }
}
