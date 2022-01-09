package com.revature;

import java.util.Scanner;

public class LogIn {

    public void LogIn(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your username");
        String username = sc.next();
        //if else statement to check if username is in database
        System.out.println("Please enter your password");
        String password = sc.next();
        // if else statement to check if password is correct
        // if credentials are correct pull up specific user profile

    }

    public void LogOut(){

    }
}
