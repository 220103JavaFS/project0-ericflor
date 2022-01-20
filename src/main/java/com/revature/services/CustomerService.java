package com.revature.services;

import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;



public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }

    public boolean requestAccount(AccountRequest request){
        return customerDAO.accountRequest(request);
    }



}
