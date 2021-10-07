package com.alex_smith.expense_reimbursement;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import com.alex_smith.expense_reimbursement.controllers.LoginController;
import com.alex_smith.expense_reimbursement.controllers.ReimbursementController;

public class EntryPoint {

	public static void main(String[] args) {

		Javalin app = Javalin.create().start(7000);

		app.get("/hello", (ctx) -> ctx.result("Hello World!"));

		app.after(ctx -> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		});

		app.config.addStaticFiles("/static", Location.CLASSPATH);

		new LoginController(app);
		new ReimbursementController(app);
	}
};
