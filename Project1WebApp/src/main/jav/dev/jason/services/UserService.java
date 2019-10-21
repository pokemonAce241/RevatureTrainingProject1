package dev.jason.services;

import java.util.Set;

import dev.jason.entities.Reimbursement;
import dev.jason.entities.User;

public interface UserService {
	
	User login(String username, String password);
	
	Reimbursement addReimbursement(Reimbursement reimbursement);
	Reimbursement getPendingReimbursement();
	Set<Reimbursement> getAllReimbursements();
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	
	
	

}
