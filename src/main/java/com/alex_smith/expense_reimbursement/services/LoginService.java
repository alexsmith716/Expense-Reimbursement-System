package com.alex_smith.expense_reimbursement.services;

import com.alex_smith.expense_reimbursement.daos.EmployeeDAO;
import com.alex_smith.expense_reimbursement.models.Employee;
import com.alex_smith.expense_reimbursement.dtos.LoginDTO;

public class LoginService {

	private EmployeeDAO employeeDao;

	public LoginService() {
		this.employeeDao = new EmployeeDAO();
	}

	public Employee checkForEmployee(LoginDTO loginAttempt) throws Exception {

		Employee e = employeeDao.getEmployeeByCredentials(loginAttempt.getEmail(), loginAttempt.getPassword());

		if(e == null) {
      throw new Exception("Incorrect Email / Password!!");
		}

		return e;
	}
}
