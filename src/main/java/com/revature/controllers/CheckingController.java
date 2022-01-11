package com.revature.controllers;

import com.revature.Models.Checking;
import com.revature.services.CheckingService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class CheckingController extends Controller{

    private CheckingService checkingService = new CheckingService();

    private Handler showChecking = (ctx) ->{
        List<Checking> list = checkingService.listCheckingAccount();

        ctx.json(list);
        ctx.status(200);
    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/checking", showChecking);
    }
}

