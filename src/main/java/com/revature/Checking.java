package com.revature;

import java.util.Scanner;

public class Checking extends Accounts{

    public Checking(float balance) {
        super(balance);
    }

    public static void display(){
        System.out.println("Checking Account");
        System.out.println("Your balance is: $" + getBalance());
        System.out.println("What would you like to do? ");
        System.out.println("Enter 1: Deposit");
        System.out.println("Enter 2: Withdraw");
        System.out.println("Enter 3: Transfer");

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        if (num == 1){
            System.out.println("How much would you like to deposit?");
            deposit();
        } else if (num == 2){
            System.out.println("How much would you like to withdraw?");
            withdraw();
        } else if (num == 3){
            System.out.println("How much would you like to transfer?");
            float amount = scan.nextFloat();
            // apply logic here to transfer funds to savings
        }
    }


}
