package com.revature.repos;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;

import java.util.List;

public interface CustomerDAO {


    public boolean addCustomer(Customer customer);

    public boolean accountRequest(AccountRequest request);

    public boolean encryptPassword(Customer customer);

}
