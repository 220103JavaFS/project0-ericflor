package com.revature.controllers;

import com.revature.models.users.AccountRequest;
import com.revature.models.users.Customer;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController extends Controller{

    private CustomerService customerService = new CustomerService();


    Handler newCustomer = (ctx)->{
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(customerService.addCustomer(customer)){
                ctx.status(201);
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
            }else {
                ctx.status(400);
            }
        }else{
            ctx.status(401);
        }
    };


    @Override
    public void addRoutes(Javalin app) {

        app.post("/customer/register", newCustomer);
        app.post("/request", newRequest);



    }
}
