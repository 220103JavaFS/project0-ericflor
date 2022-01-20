package com.revature.services;

import org.mindrot.jbcrypt.BCrypt;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;


public class LoginService {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean login(String userName, String passWord) {

        String hashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt());

        String dbPassword = customerDAO.verifyPassword(userName);

        return BCrypt.checkpw(dbPassword, hashedPW);
    }


    public boolean encryptPassword(String userName, String passWord){
        String hashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt());
        return customerDAO.encryptPassword(userName, hashedPW);
    }
}
