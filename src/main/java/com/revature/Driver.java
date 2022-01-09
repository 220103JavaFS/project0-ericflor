package com.revature;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

        while(menu != 3){
            System.out.println("What would you like to do?");
            System.out.println("Enter 1. Login");
            System.out.println("Enter 2. Register");
            System.out.println("Enter 3. Exit");

            if (menu == 1){
                LogIn enter = new LogIn();
                enter.LogIn();
            }else if (menu == 2) {
                Register newReg = new Register();
                newReg.register();
            }
            else{
                break;
            }
        }



    }
}
