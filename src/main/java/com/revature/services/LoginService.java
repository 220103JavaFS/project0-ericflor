package com.revature.services;

import com.revature.repos.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO = new LoginDAO();

    public boolean login(String username, String password){
        if(username.equals(loginDAO.findUsername(username)) && password.equals(loginDAO.findPassword(password))){
            return true;
        }else{
            return false;
        }
    }

    public boolean logout(String username, String password){
        if(username.equals("username")){
            return true;
        }else{
            return false;
        }
    }
}
