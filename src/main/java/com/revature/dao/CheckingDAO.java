package com.revature.dao;

import com.revature.Models.Checking;

import java.util.ArrayList;

public class CheckingDAO {

    private static ArrayList<Checking> checkingAccounts;

    public CheckingDAO(){

        checkingAccounts = new ArrayList<Checking>();

        checkingAccounts.add(new Checking(
                12.14
        ));
    }

    public ArrayList<Checking> getAllChecking(){
        return checkingAccounts;
    }
}
