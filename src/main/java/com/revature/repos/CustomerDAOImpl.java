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

            String sql = "INSERT INTO requests (checking, savings, user_ssn, initial_depoist)" +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setBoolean(1, request.isChecking());
            statement.setBoolean(2, request.isSavings());
            statement.setString(3, request.getUser_ssn());
            statement.setDouble(4,request.getInitialDeposit());

            statement.execute();

            return true;
        }catch (SQLException e) {
            return false;
        }
    }

    @Override
    public String verifyPassword(String username) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT pass_word FROM customers WHERE user_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return result.getString("pass_word");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean encryptPassword(String password, String username) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE customers SET pass_word = ? WHERE user_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            //statement.setString(1, username);
            statement.setString(1, password);
            statement.setString(2, username);

            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getPassword(String username) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT pass_word FROM customers WHERE user_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                return result.getString("pass_word");
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
