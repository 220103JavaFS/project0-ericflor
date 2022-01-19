package com.revature.models.users;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class User {

    private String username;
    private String password;

    public User (){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
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

}
