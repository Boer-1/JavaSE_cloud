package com.mhl.view;

import com.mhl.domain.MHL_Emp;
import com.mhl.service.DiningTableService;
import com.mhl.service.EmployeeService;
import com.mhl.utils.Utility;

public class MHLView {
    private int choice;
    private boolean loop = true;
    private final EmployeeService employeeService = new EmployeeService();
    private final DiningTableService diningTableService = new DiningTableService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }
    public void mainMenu(){
        while (loop){
            System.out.println("=============满汉楼============");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.print("请输入你的选择:");
            //接受用户输入
            choice = Utility.readInt(1);
            switch (choice){
                case 1:
                    //选择登录满汉楼，继续用户登录
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(20);
                    System.out.print("请输入密 码：");
                    String pwd = Utility.readString(20);
                    MHL_Emp emp = employeeService.getEmpById_Pwd(empId, pwd);
                    //验证以进入下一界面
                    if(emp != null){
                        System.out.println("=============登录成功[" + emp.getName() + "]===========");
                        while (loop) {
                            System.out.println("==========满汉楼二级菜单=========");
                            System.out.println("\t\t1 显示餐桌状态");
                            System.out.println("\t\t2 预定餐桌");
                            System.out.println("\t\t3 显示所有菜品");
                            System.out.println("\t\t4 点餐服务");
                            System.out.println("\t\t5 查看账单");
                            System.out.println("\t\t6 结账");
                            System.out.println("\t\t9 退出满汉楼");
                            System.out.print("请输入你的选择:");
                            choice = Utility.readInt(1);
                            switch (choice) {
                                case 1:
                                    System.out.println("==========显示餐桌状态==========");
                                    System.out.println("餐桌编号\t\t餐桌状态");
                                    diningTableService.showTableId_State();
                                    System.out.println("============显示完毕============");
                                    break;
                                case 2:
                                    System.out.println("============预定餐桌============");
                                    orderTable();
                                    break;
                                case 3:
                                    System.out.println("3");
                                    break;
                                case 4:
                                    System.out.println("4");
                                    break;
                                case 5:
                                    System.out.println("5");
                                    break;
                                case 6:
                                    System.out.println("6");
                                    break;
                                case 9:
                                    loop = false;
                                    break;
                            }
                        }
                    }else {
                        System.out.println("=============登录失败===========");
                    }
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("请输入1或2~");
            }
        }
        System.out.println("退出满汉楼系统");
    }
    public void orderTable(){
        System.out.print("请选择要预定餐桌编号(-1退出):");
        choice = Utility.readInt();
        if(choice != -1){//未退出预定
            if(diningTableService.testHaveThisTable(choice)){//验证有此桌位
                if(diningTableService.testTableAvailable(choice)){//验证此桌为空
                    char YorN = Utility.readConfirmSelection();
                    if(String.valueOf(YorN).equals("Y")){//确认是预定
                        System.out.print("请输入\n预订人名字:");
                        String orderName = Utility.readString(50);
                        System.out.print("预定人电话:");
                        String orderTel = Utility.readString(20);
                        //存档
                        if(diningTableService.setStateAndTel(orderName,orderTel, choice)){
                            System.out.println("============预定成功============");
                        }else {
                            System.out.println("神秘力量干扰，请重试~");
                        }
                    }else {
                        System.out.println("已取消预定");
                    }
                }else {
                    System.out.println("此桌正在使用中，请另选~");
                }
            }else {
                System.out.println("查无此桌，请另选~");
            }
        }else {
            System.out.println("已取消预定");
        }
    }
}
