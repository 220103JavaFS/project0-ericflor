package com.revature.services;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.Customer;
import com.revature.repos.TellerDAO;

import java.util.List;

public class TellerService {

    private TellerDAO tellerDAO = new TellerDAO();

    public boolean withdrawChecking(Checking checking){
        return tellerDAO.withdrawFromChecking(checking);
    }

    public boolean withdrawSavings(Savings savings){
        return tellerDAO.withdrawFromSavings(savings);
    }

    public boolean depositSavingsProcedure(Savings savings){
        return tellerDAO.depositIntoSavings(savings);
    }

    public boolean depositCheckingProcedure(Checking checking){
        return tellerDAO.depositIntoChecking(checking);
    }
}
