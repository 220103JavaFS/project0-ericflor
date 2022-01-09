package com.revature;

import java.util.Scanner;

public class Customer extends User{

    public Customer(String name, int age, String birthday, int social, String username, String password) {
        super(name, age, birthday, social, username, password);
    }

    public void listProfile(){
        System.out.println("CUSTOMER PROFILE:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Birthday: " + getBirthday());
        System.out.println("Social: " + getSocial());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }

    public static void customerInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Select an account to move funds");
        System.out.println("Enter 1: Checking --- Balance: $" + Checking.getBalance());
        System.out.println("Enter 2: Savings --- Balance: $" + Savings.getBalance());
        //System.out.println("Enter 3: Joint");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice == 1){
            Checking.display();
        } else if (choice == 2){
            Savings.display();
        }
    }
}
