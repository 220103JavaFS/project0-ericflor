package com.revature.controllers;

import com.revature.models.accounts.Checking;
import com.revature.models.users.Customer;
import com.revature.services.ManagerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ManagerController extends Controller{

    private ManagerService managerService = new ManagerService();

    Handler getRequests = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.showAllRequests());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getManagers = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.findAllManagers());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler addChecking = (ctx) ->{
        if(ctx.req.getSession(false)!=null){
            Checking checking = ctx.bodyAsClass(Checking.class);
            if(managerService.addCustomerChecking(checking)){
                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler getChecking = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.findAllChecking());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getSavings = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.findAllSavings());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getCustomers = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.findAllCustomers());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {

        app.get("/managers/requests", getRequests);
        app.get("/managers", getManagers);
        app.post("/managers/checking", addChecking);
        app.get("/managers/checking", getChecking);
        app.get("/managers/savings", getSavings);
        app.get("/managers/customers", getCustomers);
    }
}
