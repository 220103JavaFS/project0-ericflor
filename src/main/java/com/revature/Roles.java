package com.revature;
import io.javalin.core.security.RouteRole;

public class Roles {


    public enum Role implements RouteRole {
        CUSTOMER, TELLER, MANAGER;
    }
}
