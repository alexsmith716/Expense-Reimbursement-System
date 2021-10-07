package com.alex_smith.expense_reimbursement.controllers;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import javax.servlet.http.HttpSession;
//import com.google.gson.Gson;

import com.alex_smith.expense_reimbursement.models.Employee;
import com.alex_smith.expense_reimbursement.services.LoginService;
import com.alex_smith.expense_reimbursement.dtos.LoginDTO;

public class LoginController {
	
	private LoginService loginService;

	public LoginController(Javalin app) {
		this.loginService = new LoginService();
		app.post("/login", employeeLoginHandler);
		app.post("/logout", employeeLogoutHandler);
		app.get("/checksession", checkSessionHandler);
	}

	// ------------------------

	public Handler employeeLoginHandler = ctx -> {

		LoginDTO loginAttempt = ctx.bodyAsClass(LoginDTO.class);

		Employee employee = loginService.checkForEmployee(loginAttempt);

		HttpSession httpSession = ctx.req.getSession();
		httpSession.setAttribute("employeeSession", employee);

		if (employee != null) {
			ctx.json(employee);
			ctx.status(200);
		} else {
			ctx.result("{}");
			ctx.status(404);
		}
	};

	private Handler employeeLogoutHandler = ctx -> {

		if(ctx.sessionAttribute("employeeSession") == null) {
			ctx.json("No user currently logged in +++++++++++++++++++++++++");
			ctx.status(400);
		} else {
			ctx.req.getSession().invalidate();
			ctx.json("User successfully logged out +++++++++++++++++++++++");
			ctx.status(200);
		}
	};

	private Handler checkSessionHandler = ctx -> {

		HttpSession httpSession = ctx.req.getSession();

		if(httpSession.getAttribute("employeeSession") == null) {
			ctx.json("User is not currently logged in ++++++++++++++++++=");
			ctx.status(404);
		} else {
			Employee employee = (Employee) httpSession.getAttribute("employeeSession");
			ctx.json(employee);
			ctx.status(200);
		}
	};
}
