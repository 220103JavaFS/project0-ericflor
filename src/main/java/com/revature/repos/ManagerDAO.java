package com.revature.repos;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.models.users.Manager;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {

    public List<AccountRequest> showAll() {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM requests;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<AccountRequest> list = new ArrayList<>();

            while(result.next()){
                AccountRequest requests = new AccountRequest();

                requests.setChecking(result.getBoolean("checking"));
                requests.setSavings(result.getBoolean("savings"));
                requests.setUser_ssn(result.getString("user_ssn"));
                requests.setInitialDeposit(result.getDouble("initial_depoist"));

                list.add(requests);
            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<AccountRequest>();
    }

    public List<Manager> findAllManagers() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM managers;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Manager> list = new ArrayList<>();

            while(result.next()){
                Manager managers = new Manager();

                managers.setManagerId(result.getInt("manager_id"));
                managers.setUsername(result.getString("user_name"));
                managers.setPassword(result.getString("user_password"));

                list.add(managers);
            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Manager>();
    }

    public boolean addChecking(Checking checking){
        try(Connection conn = ConnectionUtil.getConnection()){


            String sql = "INSERT INTO checking (balance, customer_ssn) " +
                    "VALUES (?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, checking.getBalance());
            statement.setString(2, checking.getCustomerSSN());

            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public List<Checking> findAllChecking() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql2 = "DROP TABLE IF EXISTS customer_checking;";
            String sql1 = "SELECT customers.first_name, customers.last_name, checking.balance, checking.customer_ssn \n" +
                    "\tINTO customer_checking \n" +
                    "\tFROM customers\n" +
                    "\tINNER JOIN checking ON customers.ssn = checking.customer_ssn;";
            String sql = "SELECT * FROM customer_checking";

            Statement statement = conn.createStatement();
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement2.execute();
            statement1.execute();

            ResultSet result = statement.executeQuery(sql);

            List<Checking> list = new ArrayList<>();

            while(result.next()){

                Checking checking = new Checking();

                checking.setBalance(result.getDouble("balance"));
                checking.setCustomerSSN(result.getString("customer_ssn"));
                checking.setCustomerFirstName(result.getString("first_name"));
                checking.setCustomerLastName(result.getString("last_name"));

                list.add(checking);
            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Checking>();
    }

    public boolean addSavings(Savings savings){
        try(Connection conn = ConnectionUtil.getConnection()){


            String sql = "INSERT INTO savings (balance, customer_ssn) " +
                    "VALUES (?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, savings.getBalance());
            statement.setString(2, savings.getCustomerSSN());

            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public List<Savings> findAllSavings() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql2 = "DROP TABLE IF EXISTS customer_savings;";
            String sql1 = "SELECT customers.first_name, customers.last_name, savings.balance, savings.customer_ssn \n" +
                    "\tINTO customer_savings\n" +
                    "\tFROM customers\n" +
                    "\tINNER JOIN savings ON customers.ssn = savings.customer_ssn;";
            String sql = "SELECT * FROM customer_savings";

            Statement statement = conn.createStatement();
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement2.execute();
            statement1.execute();

            ResultSet result = statement.executeQuery(sql);

            List<Savings> list = new ArrayList<>();

            while(result.next()){

                Savings savings = new Savings();

                savings.setBalance(result.getDouble("balance"));
                savings.setCustomerSSN(result.getString("customer_ssn"));
                savings.setCustomerFirstName(result.getString("first_name"));
                savings.setCustomerLastName(result.getString("last_name"));

                list.add(savings);
            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Savings>();
    }

    public boolean deleteSavings(Savings savings){
        try(Connection conn = ConnectionUtil.getConnection()){


            String sql = "DELETE FROM savings WHERE customer_ssn = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, savings.getCustomerSSN());

            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public boolean deleteChecking(Checking checking){
        try(Connection conn = ConnectionUtil.getConnection()){


            String sql = "DELETE FROM checking WHERE customer_ssn = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, checking.getCustomerSSN());

            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public List<Customer> findAllCustomers() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM customers;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<>();

            while(result.next()){
                Customer customers = new Customer();

                customers.setSsn(result.getString("ssn"));
                customers.setFirstName(result.getString("first_name"));
                customers.setLastName(result.getString("last_name"));
//                customers.setUsername(result.getString("user_name"));
//                customers.setPassword(result.getString("pass_word"));


                list.add(customers);
            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }
}
