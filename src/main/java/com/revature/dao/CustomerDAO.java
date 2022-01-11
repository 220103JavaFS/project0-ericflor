package com.revature.dao;

import com.revature.Models.Checking;
import com.revature.Models.Customer;

import java.util.ArrayList;

public class CustomerDAO {

    private static ArrayList<Customer> customers;

    public CustomerDAO(){

        customers = new ArrayList<Customer>();

        customers.add(new Customer(
                "Eric",
                "Florence",
                "ericflo",
                "ca38jdk3",
                "000-00-1111", new Checking(12.13)));

    }

    public ArrayList<Customer> getAllCustomers(){
        return customers;
    }
}
