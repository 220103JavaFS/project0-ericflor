package com.revature.controllers;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;
import com.revature.services.TellerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TellerController extends Controller {

    protected static Logger log = LoggerFactory.getLogger(TellerController.class);

    private TellerService tellerService = new TellerService();

    Handler withdrawChecking = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
            Checking checking = ctx.bodyAsClass(Checking.class);
            if(tellerService.withdrawChecking(checking)){
                ctx.status(201);
                log.info("Successfully made a withdrawal from checking");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler withdrawSavings = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
            Savings savings = ctx.bodyAsClass(Savings.class);
            if(tellerService.withdrawSavings(savings)){
                ctx.status(201);
                log.info("Successfully made a withdrawal from savings");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler depositSavingsProcedure = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
            Savings saving = ctx.bodyAsClass(Savings.class);
            if(tellerService.depositSavingsProcedure(saving)){
                ctx.status(201);
                log.info("Successfully made a deposit into savings");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler depositCheckingProcedure = (ctx) ->{

        if(ctx.req.getSession(false)!=null){
            Checking checkings = ctx.bodyAsClass(Checking.class);
            if(tellerService.depositCheckingProcedure(checkings)){
                ctx.status(201);
                log.info("Successfully made a deposit into checking");
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/checking/withdraw", withdrawChecking);
        app.post("/savings/withdraw", withdrawSavings);
        app.post("/savings/deposit", depositSavingsProcedure);
        app.post("/checking/deposit", depositCheckingProcedure);
    }
}
