package com.revature.repos;

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

            String sql = "SELECT username FROM users WHERE username = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            User user = new User();

            statement.setString(1, user.getUsername());

            return username;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

//    public String findPassword(String password) {
//        try(Connection conn = ConnectionUtil.getConnection()){
//
//            String sql = "SELECT user_password FROM users WHERE user_password = ?;";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//
//            User user = new User();
//
//            statement.setString(1, user.getPassword());
//
//            return password;
//
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}

