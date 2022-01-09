package com.revature;

import java.util.Scanner;

public abstract class User {

    private String name;
    private int age;
    private String birthday;
    private int social;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, int age, String birthday, int social, String username, String password) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.social = social;
        this.username = username;
        this.password = password;
    }



}
