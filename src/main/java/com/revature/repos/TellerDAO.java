package com.revature.repos;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TellerDAO {

    public boolean depositIntoChecking(Checking checking){
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "CALL depositChecking(?,"+checking.getAmount()+");";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, checking.getCustomerSSN());

            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public boolean depositIntoSavings(Savings savings){
        try(Connection conn = ConnectionUtil.getConnection()){

            //String sql = "UPDATE savings SET balance = balance + ? WHERE customer_ssn = ?;";
            String sql = "CALL depositSavings(?,"+savings.getAmount()+");";

            PreparedStatement statement = conn.prepareStatement(sql);
            //CallableStatement statement = conn.prepareCall(sql);

            statement.setString(1, savings.getCustomerSSN());


            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public boolean withdrawFromSavings(Savings savings){
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql1 = "UPDATE savings SET balance = balance - ? WHERE customer_ssn = ?;";
            //String sql = "CALL depositSavings(?,?);";

            PreparedStatement statement = conn.prepareStatement(sql1);
            //CallableStatement statement = conn.prepareCall(sql);

            statement.setDouble(1, savings.getAmount());
            statement.setString(2, savings.getCustomerSSN());


            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }

    public boolean withdrawFromChecking(Checking checking){
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "UPDATE checking SET balance = balance - ? WHERE customer_ssn = ?;";
            //String sql = "CALL depositSavings(?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            //CallableStatement statement = conn.prepareCall(sql);

            statement.setDouble(1, checking.getAmount());
            statement.setString(2, checking.getCustomerSSN());


            statement.execute();

            return true;

        }catch (SQLException e){
            return false;
        }
    }
}
