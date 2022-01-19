package com.revature.controllers;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.models.users.Customer;
import com.revature.models.users.Manager;
import com.revature.models.users.User;
import com.revature.services.ManagerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ManagerController extends Controller{

    protected static Logger log = LoggerFactory.getLogger(ManagerController.class);

    private ManagerService managerService = new ManagerService();

    Handler getRequests = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.showAllRequests());
            ctx.status(200);
            log.info("The list of account requests");
        }else {
            ctx.status(401);
        }
    };

    Handler getManagers = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //getSession(false) will only return a Session object if the client
            //sent a cookie along with the request that matches an open session.
            ctx.json(managerService.findAllManagers());
            ctx.status(200);
            log.info("The list of managers");
        }else {
            ctx.status(401);
        }
    };

    Handler addChecking = (ctx) ->{
        if(ctx.req.getSession(false)!=null){
            Checking checking = ctx.bodyAsClass(Checking.class);
            if(managerService.addCustomerChecking(checking)){
                ctx.status(201);
                log.info("Successfully approved customer checking account");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler addSavings = (ctx) ->{
        if(ctx.req.getSession(false)!=null){
            Savings savings = ctx.bodyAsClass(Savings.class);
            if(managerService.addCustomerSavings(savings)){
                ctx.status(201);
                log.info("Successfully approved customer savings account");
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
            log.info("List of all customer checking accounts");
        }else {
            ctx.status(401);
        }
    };

    Handler getSavings = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(managerService.findAllSavings());
            ctx.status(200);
            log.info("List of all customer savings accounts");
        }else {
            ctx.status(401);
        }
    };

    Handler deleteSavings = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
           Savings savings = ctx.bodyAsClass(Savings.class);
            if(managerService.deleteCustomerSavings(savings)){
                ctx.status(201);
                log.info("Successfully deleted customer savings account");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler deleteChecking = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
            Checking checking = ctx.bodyAsClass(Checking.class);
            if(managerService.deleteCustomerChecking(checking)){
                ctx.status(201);
                log.info("Successfully deleted customer checking account");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler getCustomers = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(managerService.findAllCustomers());
            ctx.status(200);
            log.info("The list of all the customers");
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {

        app.get("/managers/requests", getRequests);
        //app.get("/managers/requests", getRequests, MANAGER); // how to do this????
        app.get("/managers", getManagers);
        app.post("/managers/checking", addChecking);
        app.post("/managers/savings", addSavings);
        app.post("/savings/delete", deleteSavings);
        app.post("/checking/delete", deleteChecking);
        app.get("/managers/checking", getChecking);
        app.get("/managers/savings", getSavings);
        app.get("/managers/customers", getCustomers);
    }
}
