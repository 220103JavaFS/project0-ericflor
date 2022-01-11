package com.revature.controllers;

import com.revature.Models.Customer;
import com.revature.services.CustomerService;
import java.util.List;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController extends Controller {

    private CustomerService customerService = new CustomerService();

    private Handler getCustomers = (ctx) ->{
        List<Customer> list = customerService.listAllCustomers();

        ctx.json(list);
        ctx.status(200);
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/customer", getCustomers);
    }
}
