package com.alex_smith.expense_reimbursement.controllers;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import javax.servlet.http.HttpSession;
import java.util.List;

import com.alex_smith.expense_reimbursement.dtos.ReimbursementDTO;
import com.alex_smith.expense_reimbursement.models.Reimbursement;
import com.alex_smith.expense_reimbursement.models.Employee;
import com.alex_smith.expense_reimbursement.services.ReimbursementService;

public class ReimbursementController {

	private ReimbursementService reimbursementService;

	public ReimbursementController(Javalin app) {
		this.reimbursementService = new ReimbursementService();

		app.get("/employees/:employeeid/reimbursements", getAllEmployeeReimbursements);
		app.post("/employees/:employeeid/reimbursements", createEmployeeReimbursement);
	}

	// -----------------------

	private Handler getAllEmployeeReimbursements = ctx -> {

		HttpSession session = ctx.req.getSession();

		if (session.getAttribute("employeeSession") == null) {

			ctx.json("Invalid Session +++++++++++");

		} else {
			Employee employee = (Employee) session.getAttribute("employeeSession");

			String employeeID = ctx.pathParam("employeeid");

			if (employee.geteID() == Integer.parseInt(employeeID)) {

				List<Reimbursement> allReimbursements = reimbursementService.getAllReimbursementsFromEmployeeId(employeeID);

				ctx.json(allReimbursements);
				ctx.status(200);

			} else {

				ctx.json("Invalid Session +++++++++++");
				ctx.status(401);
			}
		}
	};

	// -----------------------

	private Handler createEmployeeReimbursement = ctx -> {

		HttpSession session = ctx.req.getSession();

		if (session.getAttribute("employeeSession") == null) {

			ctx.json("Invalid Session +++++++++++");

		} else {

			Employee employee = (Employee) session.getAttribute("employeeSession");

			// Couldn't deserialize body to ReimbursementDTO

			ReimbursementDTO createdReimbursement = ctx.bodyAsClass(ReimbursementDTO.class);

			String id = ctx.pathParam("employeeid");

			if (employee.geteID() == Integer.parseInt(id)) {

				Reimbursement newReimbursement = reimbursementService.creatReimbursementById(id, createdReimbursement);

				ctx.json(newReimbursement);
				ctx.status(200);

			} else {
				ctx.json("Invalid Session +++++++++++");
				ctx.status(401);
			}
		}
	};
}
