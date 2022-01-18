package com.revature.services;

import com.revature.repos.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO = new LoginDAO();

    public boolean login(String username, String password){
        if(username.equals(loginDAO.findUsername(username))){
            return true;
        }else{
            return false;
        }
    }
}
