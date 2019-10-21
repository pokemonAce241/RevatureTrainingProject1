package dev.jason.services;

import java.util.Set;

import dev.jason.daos.ReimbursementDAO;
import dev.jason.daos.ReimbursementDAOjdbc;

import dev.jason.daos.UserDAO;
import dev.jason.daos.UserDAOjdbc;
import dev.jason.entities.Reimbursement;
import dev.jason.entities.User;

public class UserServiceImpl implements UserService{
	
	
	
	public static UserDAO udao = UserDAOjdbc.getUserDAOjdbc();
	public static ReimbursementDAO rdao = ReimbursementDAOjdbc.getReimbursementDAOjdbc();

	@Override
	public User login(String username, String password) {
		return udao.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement reimbursement) {
		
		return rdao.createReimbursement(reimbursement);
	}

	@Override
	public Reimbursement getPendingReimbursement() {
		return rdao.getFirstPendingReimbursement();
	}

	@Override
	public Set<Reimbursement> getAllReimbursements() {
		return rdao.getAllReimbursements();
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		
		return rdao.updateReimbursement(reimbursement);
	}

	
}
