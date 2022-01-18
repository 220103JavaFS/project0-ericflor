package com.revature.repos;

import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{


    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO customers (ssn, first_name, last_name, user_name, pass_word) " +
                    "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);


            int count = 0;
            statement.setString(++count, customer.getSsn());
            statement.setString(++count, customer.getFirstName());
            statement.setString(++count, customer.getLastName());
            statement.setString(++count, customer.getUsername());
            statement.setString(++count, customer.getPassword());

            statement.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean accountRequest(AccountRequest request) {
        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO requests (checking, savings, user_ssn)" +
                    "VALUES (?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setBoolean(1, request.isChecking());
            statement.setBoolean(2, request.isSavings());
            statement.setString(3, request.getUser_ssn());

            statement.execute();

            return true;
        }catch (SQLException e) {
            return false;
        }
    }

}
