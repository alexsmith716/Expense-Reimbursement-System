package com.alex_smith.expense_reimbursement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursements")
public class Reimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rID")
	private int rID;

	@Column(name = "amount")
	private double amount;

	@Column(name = "submitted")
	private String submitted;

	@Column(name = "approved")
	private String approved;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private int status;

	@Column(name = "type")
	private int type;

	@Column(name = "message")
	private String message;

	// -------------------------

	@ManyToOne
	@JoinColumn(name = "empReimJoinID")
	private Employee employeeReimbursementJoiner;

	// -------------------------

	public Reimbursement() {
		super();
	}

	public Reimbursement(double amount, String submitted, String approved, String description, String status, int type, int message) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.approved = approved;
		this.description = description;
		this.status = status;
		this.type = type;
		this.message = message;
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// -------------------------

	public Employee getEmployeeReimbursementJoiner() {
		return employeeReimbursementJoiner;
	}

	public void setEmployeeReimbursementJoiner(Employee employeeReimbursementJoiner) {
		this.employeeReimbursementJoiner = employeeReimbursementJoiner;
	}

	// -------------------------

	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", amount=" + amount + ", submitted=" + submitted + ", approved=" + approved + ", description=" + description + ", status=" + status + ", type=" + type + ", message=" + message + ", employeeReimbursementJoiner=" + employeeReimbursementJoiner + "]";
	}
}
