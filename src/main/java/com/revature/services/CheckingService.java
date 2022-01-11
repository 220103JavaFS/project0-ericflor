package com.revature.services;

import com.revature.Models.Checking;
import com.revature.dao.CheckingDAO;

import java.util.ArrayList;

public class CheckingService {

    public CheckingDAO checkingDAO = new CheckingDAO();


    public ArrayList<Checking> listCheckingAccount() {
        return checkingDAO.getAllChecking();
    }
}
