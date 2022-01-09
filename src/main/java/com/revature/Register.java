package com.revature;

import java.util.Scanner;

public class Register {

    public void register(){
        System.out.println("Please fill out the following information to register");
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your full name?");
        String name = scan.nextLine();

        System.out.println("What is your age?");
        int age = scan.nextInt();

        System.out.println("What is your birthday? (enter in format MM/DD/YYYY)");
        String birthday = scan.next();

        System.out.println("What is your social? (don't use any dashes, just your 9 numbers)");
        int social = scan.nextInt();
        // if else statement here to check if number is already in database

        System.out.println("Please enter a username for your profile");
        String username = scan.next();
        // if else statement here to check if social is already in database

        System.out.println("Please enter a password for your profile");
        String password = scan.next();

        //System.out.println("Are your registering as a customer, Teller, or Bank Manager?");
        // if customer, create new object for customer filling in provided data
        // if teller, create new object for teller filling in provided data, etc.
        Customer newCust = new Customer(name, age, birthday, social, username, password);
        System.out.println("Your new profile information is: ");
        newCust.listProfile();
        System.out.println("Thank you for registering");
    }
}
