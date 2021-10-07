package com.alex_smith.expense_reimbursement.daos;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
// import org.hibernate.query.Query;
import org.hibernate.HibernateException;

import com.alex_smith.expense_reimbursement.models.Employee;
import com.alex_smith.expense_reimbursement.util.HibernateSessionFactory;

public class EmployeeDAO {
	
	public Employee getEmployeeByCredentials(String email, String password) {

		Employee employee = null;
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			employee = (Employee) session.createQuery("From Employee E WHERE E.email = :email AND E.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();

			tx.commit();

		}catch(HibernateException e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			session.close();
		}
		return employee;
	}
}
