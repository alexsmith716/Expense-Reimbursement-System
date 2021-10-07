package com.alex_smith.expense_reimbursement.services;

import java.util.List;

import com.alex_smith.expense_reimbursement.daos.ReimbursementDAO;
import com.alex_smith.expense_reimbursement.dtos.ReimbursementDTO;
import com.alex_smith.expense_reimbursement.models.Reimbursement;

public class ReimbursementService {

	private ReimbursementDAO reimbursementDAO;

	public ReimbursementService() {
		this.reimbursementDAO = new ReimbursementDAO();
	}

	public List<Reimbursement> getAllReimbursementsFromEmployeeId(String employeeID) {
		int id = Integer.parseInt(employeeID);

		List<Reimbursement> allReimbursements = reimbursementDAO.getAllReimbursementsFromEmployeeId(id);

		return allReimbursements;
	}

	public Reimbursement creatReimbursementById(String id, ReimbursementDTO createdReimbursement) {
		int intID = Integer.parseInt(id);
		Reimbursement cr = reimbursementDAO.createReimbursementById(intID, createdReimbursement);
		return cr;
	}
}
