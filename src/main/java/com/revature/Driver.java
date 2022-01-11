package com.revature;

import com.revature.controllers.CheckingController;
import com.revature.controllers.Controller;
import com.revature.controllers.CustomerController;
import io.javalin.Javalin;

public class Driver {

    private static Javalin driver;

    public static void main(String[] args) {
        driver = Javalin.create();

//        driver.get("/hello", ((ctx) -> {
//            String url = ctx.url();
//            System.out.println(url);
//            ctx.html("<h1> Hello Javalin </h1>");
//            ctx.status(200);
//        }));
        configure(new CheckingController());
        configure(new CustomerController());
        driver.start(7000);
    }

    public static void configure(Controller... controllers){

        for (Controller c: controllers){
            c.addRoutes(driver);
        }
    }
}

