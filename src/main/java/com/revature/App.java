package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.CustomerController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static Javalin app;
    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        app = Javalin.create();

        configure(new CustomerController(), new LoginController(), new ManagerController());

        app.start(7000);
    }

    public static void configure(Controller... controllers){

        for (Controller c: controllers){
            c.addRoutes(app);
        }
    }
}


