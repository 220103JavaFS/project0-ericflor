package com.revature.services;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.models.users.Manager;
import com.revature.repos.ManagerDAO;

import java.util.List;

public class ManagerService {

    private ManagerDAO managerDAO = new ManagerDAO();

    public List<AccountRequest> showAllRequests(){
        return managerDAO.showAll();
    }

    public List<Manager> findAllManagers() {
        return managerDAO.findAllManagers();
    }

    public boolean addCustomerChecking(Checking checking){
        return managerDAO.addChecking(checking);
    }

    public List<Checking> findAllChecking() {
        return managerDAO.findAllChecking();
    }

    public List<Savings> findAllSavings() {
        return managerDAO.findAllSavings();
    }

    public List<Customer> findAllCustomers(){
        return managerDAO.findAllCustomers();
    }
}
