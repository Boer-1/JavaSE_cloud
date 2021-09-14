package com.changesys.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean loop = true;
    String detail_interface = "===============Change Details=============";
    double amount = 0;
    double change = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Scanner scanner = new Scanner(System.in);
    int choice;
    String address;
    double consume;
    char judge;

    public void mainMenu(){
        do {
            System.out.println("===============Change System=============");
            System.out.println("\t\t\t 1 Change Details");
            System.out.println("\t\t\t 2 Income");
            System.out.println("\t\t\t 3 Consume");
            System.out.println("\t\t\t 4 Quit");
            System.out.println("Please select (1-4)");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    this.detail();
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.consume();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("Error input");
            }
        }while (loop);
        System.out.println("You have successfully pulled out of System");

    }
    public void detail(){
        System.out.println(detail_interface);
    }
    public void income(){
        System.out.println("input your Income:");
        amount = scanner.nextDouble();
        if(amount < 0){
            return;
        }
        change += amount;
        date = new Date();
        detail_interface += "\nEarnings recorded\t+"+ amount + "\t" + sdf.format(date)+"\tbalance:"+ change;
    }
    public void consume(){
        System.out.println("Input Consumption amount:");
        consume = scanner.nextDouble();
        if(consume < 0||consume > change) return;
        System.out.println("Input Consume address");
        address = scanner.next();
        change -= consume;
        date = new Date();
        detail_interface += "\n" + address + "\t-"+ consume + "\t" + sdf.format(date)+"\tbalance:"+ change;
    }
    public void exit(){
        System.out.print("Really Quit?");
        for(; loop;){
            System.out.println("(y/n)");
            judge = scanner.next().charAt(0);
            if(judge == 'y'){
                loop = false;
            }else if(judge == 'n'){
                break;
            }else{
                System.out.println("Error input,try again~");
            }
        }
    }
}
