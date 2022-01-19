package com.revature.controllers;

import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.models.users.User;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomerController extends Controller{

    protected static Logger log = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService = new CustomerService();


    Handler newCustomer = (ctx)->{
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(customerService.addCustomer(customer)){

                ctx.status(201);
                log.info("Created new customer");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }

    };

    Handler newRequest = (ctx) ->{
        if(ctx.req.getSession(false)!=null){
            AccountRequest request = ctx.bodyAsClass(AccountRequest.class);
            if(customerService.requestAccount(request)){
                ctx.status(201);
                log.info("Created new account request");
            }else {
                ctx.status(400);
                log.warn("Customer doesn't exist in database, please register first");
            }                           // put some logback here with message about since ssn not in registered
        }else{                          // customers, can't request account, please register
            ctx.status(401);
            log.warn("Customer doesn't exist in database, please register first");
        }
    };

    Handler passwordEncrypt = (ctx)->{
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(customerService.encryptPassword(customer)){

                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }

    };

    @Override
    public void addRoutes(Javalin app) {

        //app.post("/register", newCustomer, Role.CUSTOMER); // how to do this?
        app.post("/register", newCustomer);
        app.post("/request", newRequest);
        app.post("/encrypt", passwordEncrypt);
       // app.post("/customer/request", newRequest, CUSTOMER); // how to do this?
    }
}
