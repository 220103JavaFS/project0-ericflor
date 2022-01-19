package com.revature.controllers;

import com.revature.models.users.User;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginController extends Controller {

    protected static Logger log = LoggerFactory.getLogger(LoginController.class);

    LoginService loginService = new LoginService();

    private Handler login = (ctx) -> {
        User user = ctx.bodyAsClass(User.class); //A DTO (Data transfer object) is a temporary object used just to communicate information.

        if(loginService.login(user.getUsername(), user.getPassword())){
            ctx.req.getSession(); //This will return an HttpSession object. If none exists then a new one will be created
            //and a cookie will be added to the response for the client to store.
            ctx.status(200);
            log.info("Successfully logged in");
        }else {
            ctx.req.getSession().invalidate(); //invalidates any open session that is attached to the client that sent invalid credentials.
            ctx.status(401);
            log.warn("Invalid credentials!");
        }
    };


    private Handler logout = (ctx) -> {

        ctx.req.getSession().invalidate();
        ctx.status(200);
        log.info("Successfully logged out");

    };


    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", login);
        app.post("/logout", logout);
    }
}
