package com.alex_smith.expense_reimbursement.dtos;

public class ReimbursementDTO {

	private double reimbursementAmount;
	private String reimbursementSubmitted;
	private String reimbursementDescription;
	private int reimbursementStatus;
	private int reimbursementType;

	public ReimbursementDTO() {
		super();
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public String getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(String reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public int getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(int reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
}
