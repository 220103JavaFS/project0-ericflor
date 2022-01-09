package com.revature;

import java.util.Scanner;

public abstract class Accounts {

    private static float balance = 0;
    private static float amount = 0;

    public Accounts(float balance) {
        this.balance = balance;
    }

    public static float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public static float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    public static void deposit(){
        Scanner deposit = new Scanner(System.in);
        amount = deposit.nextFloat();
        balance = balance + amount;
        System.out.println("Your new balance is: $" + balance);
    }

    public static void withdraw(){
        Scanner withdraw = new Scanner(System.in);
        amount = withdraw.nextFloat();
        if (balance < amount){
            System.out.println("Sorry! Your account will overdraw!");
            System.out.println("Please enter another amount --- Current Balance: $" + getBalance());
            withdraw();
        } else {
            balance = balance - amount;
            System.out.println("Your new balance is: $" + balance);
        }
    }

}
