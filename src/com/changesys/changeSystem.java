package com.changesys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class changeSystem {
    public static void main(String[] args) {
        boolean loop = true;
        String detail_interface = "===============Change Details=============";
        double amount = 0;
        double change = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String address;
        double consume;

        char judge;
        //To run
        do {
            System.out.println("===============Change System=============");
            System.out.println("\t\t\t 1 Change Details");
            System.out.println("\t\t\t 2 Income");
            System.out.println("\t\t\t 3 Consume");
            System.out.println("\t\t\t 4 Quit");
            System.out.println("Please select (1-4)");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    System.out.println(detail_interface);
                    break;
                case 2:
                    System.out.println("input your Income:");
                    amount = scanner.nextDouble();
                    if(amount < 0){
                        break;
                    }
                    change += amount;
                    date = new Date();
                    detail_interface += "\nEarnings recorded\t+"+ amount + "\t" + sdf.format(date)+"\tbalance:"+ change;
                    break;
                case 3:
                    System.out.println("Input Consumption amount:");
                    consume = scanner.nextDouble();
                    if(consume < 0||consume > change) break;
                    System.out.println("Input Consume address");
                    address = scanner.next();
                    change -= consume;
                    date = new Date();
                    detail_interface += "\n" + address + "\t-"+ consume + "\t" + sdf.format(date)+"\tbalance:"+ change;
                    break;
                case 4:
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
                    break;
                default:
                    System.out.println("Error input");
            }
        }while (loop);
        System.out.println("You have successfully pulled out of System");
    }
}
