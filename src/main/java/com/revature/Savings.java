package com.revature;

import java.util.Scanner;

public class Savings extends Accounts{

    public Savings(float balance) {
        this.setBalance(0);
    }

    public static void displaySavings(){
        System.out.println("Savings Account");
        System.out.println("Your balance is: $" + getBalance());
        System.out.println("What would you like to do? ");
        System.out.println("Enter 1: Deposit");
        System.out.println("Enter 2: Withdraw");
        System.out.println("Enter 3: Transfer");

        Scanner scan = new Scanner(System.in);

        int sc = scan.nextInt();

        if (sc == 1){
            System.out.println("How much would you like to deposit?");
            Savings.deposit();
        } else if (sc == 2){
            System.out.println("How much would you like to withdraw?");
            Savings.withdraw();
        } else if (sc == 3){
            System.out.println("How much would you like to transfer?");
            float amount = scan.nextFloat();
            // apply logic here to transfer funds to checking
        }
        Customer.customerInfo();
    }
}
