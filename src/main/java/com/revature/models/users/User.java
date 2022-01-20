package com.revature.models.users;

import com.revature.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class User {


    private String username;
    public String password;

    public User (){

    }

    public User(String username){
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;

        String x = BCrypt.hashpw(password, BCrypt.gensalt());

        this.password = x;

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
