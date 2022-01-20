package com.revature.controllers;

import com.revature.models.UserDTO;
import com.revature.models.users.Customer;
import com.revature.models.users.User;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginController extends Controller {

    protected static Logger log = LoggerFactory.getLogger(LoginController.class);

    LoginService loginService = new LoginService();

    private Handler loginCustomer = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class); //A DTO (Data transfer object) is a temporary object used just to communicate information.

        if(loginService.login(user.userName, user.custPassword)){
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

    private Handler encryptPassword = (ctx)->{
        if(ctx.req.getSession(false)!=null) {

            UserDTO user = ctx.bodyAsClass(UserDTO.class);

            if(loginService.encryptPassword(user.userName, user.custPassword)){
                ctx.status(200);
            }else{
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };



    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginCustomer);
        app.post("/logout", logout);
        app.post("/encrypt", encryptPassword);
    }
}
