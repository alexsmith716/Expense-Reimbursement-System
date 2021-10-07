package com.alex_smith.expense_reimbursement.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.alex_smith.expense_reimbursement.dtos.ReimbursementDTO;
import com.alex_smith.expense_reimbursement.models.Reimbursement;
import com.alex_smith.expense_reimbursement.models.Employee;
import com.alex_smith.expense_reimbursement.util.HibernateSessionFactory;

public class ReimbursementDAO {

	public List<Reimbursement> getAllReimbursementsFromEmployeeId(int id) {

		List<Reimbursement> allReimbursements = null;
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			allReimbursements = session.createQuery("SELECT r FROM Reimbursement r JOIN r.employeeReimbursementJoiner e WHERE e.eID = :employeeid").setParameter("employeeid", id).getResultList();

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();

			e.printStackTrace();
		}finally {
			session.close();
		}

		return allReimbursements;
	}

	public Reimbursement createReimbursementById(int eID, ReimbursementDTO newRData) {

		Reimbursement newReimbursement = new Reimbursement();
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();

			newReimbursement.setAmount(newRData.getReimbursementAmount());
			newReimbursement.setSubmitted(newRData.getReimbursementSubmitted());
			newReimbursement.setDescription(newRData.getReimbursementDescription());

      // FIX THIS!
			// newReimbursement.setType(newRData.getReimbursementType());
      // newReimbursement.setStatus(newRData.getReimbursementStatus());


			newReimbursement.setEmployeeReimbursementJoiner(session.get(Employee.class, eID));
			
			session.save(newReimbursement);

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}

		return newReimbursement;
	}
}
