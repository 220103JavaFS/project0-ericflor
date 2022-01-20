package com.revature.repos;

import com.revature.models.users.Customer;
import com.revature.models.users.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO{

    public String findUsername(String username) { // remember this needs to be a string so we can return the actual
        // string for username and password to compare it to the string
        // passed through the post request to /login
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT user_name FROM customers WHERE user_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            Customer cust = new Customer();

            statement.setString(1, cust.getUsername());

            return username;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String findPassword(String password) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT user_password FROM customers WHERE user_password = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            Customer cust = new Customer();

            statement.setString(1, cust.getPassword());

            return password;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

