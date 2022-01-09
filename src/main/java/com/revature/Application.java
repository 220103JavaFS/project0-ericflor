package com.revature;

import java.util.Scanner;

public class Application {

    public String checking;
    public String savings;

    public void openAccount(){
        System.out.println("What kind of account would you like to open?");
        System.out.println("Enter 1. Checking");
        System.out.println("Enter 2. Savings");
        System.out.println("Enter 3. Joint");

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if (num == 1){
            Checking check = new Checking(0);
            Customer.customerInfo();
        } else if (num == 2){
            Savings save = new Savings(0);
            Customer.customerInfo();
        } else if (num == 3){
            // open new joint account
        }
    }
}
