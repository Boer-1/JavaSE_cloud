package com.homework;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account("3454523314","张三");
        Account b = new Account("3454524315","李四");
        a.print();
        b.print();
        Account.interestrate = 0.9;
        System.out.println("修改存款利率后:");
        a.print();
        b.print();
    }
}
//银行账户类
class Account{
    private String accountNumber;
    private String accountName;
    private double balance;
    static double interestrate = 0.1;

    public Account(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        balance = 0.0;
    }
    public void print(){
        System.out.println("账号:"+accountNumber);
        System.out.println("账户名:"+accountName);
        System.out.println("存款利率:"+interestrate);
    }
}
