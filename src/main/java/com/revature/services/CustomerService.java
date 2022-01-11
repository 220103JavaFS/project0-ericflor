package com.revature.services;

import com.revature.Models.Customer;
import com.revature.dao.CustomerDAO;

import java.util.ArrayList;

public class CustomerService {

    public CustomerDAO customerDAO = new CustomerDAO();

    public ArrayList<Customer> listAllCustomers(){
        return customerDAO.getAllCustomers();
    }
}
