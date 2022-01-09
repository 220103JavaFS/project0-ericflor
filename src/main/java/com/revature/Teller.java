package com.revature;

public class Teller extends User{

    public Teller(String name, int age, String birthday, int social, String username, String password) {
        super(name, age, birthday, social, username, password);
    }

    public void listProfile(){
        System.out.println("TELLER PROFILE:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Birthday: " + getBirthday());
        System.out.println("Social: " + getSocial());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }
}
