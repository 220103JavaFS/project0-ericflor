package com.revature.controllers;

import com.revature.services.AccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class AccountController extends Controller{

    private AccountService accountService = new AccountService();

    private Handler deposit = (ctx) ->{



        ctx.status(200);
    };


    @Override
    public void addRoutes(Javalin app) {

    }
}
