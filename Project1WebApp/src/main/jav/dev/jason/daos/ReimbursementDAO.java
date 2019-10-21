package dev.jason.daos;

import java.util.Set;

import dev.jason.entities.Reimbursement;

public interface ReimbursementDAO {

		//create
			Reimbursement createReimbursement(Reimbursement reimbursement);
	
		//read
			Reimbursement getReimbursementById(int id);
			Reimbursement getFirstPendingReimbursement();
			Set<Reimbursement> getAllReimbursements();
			
		//update
			Reimbursement updateReimbursement(Reimbursement reimbursement);
		
		//delete
			Reimbursement deleteReimbursement(Reimbursement reimbursement);

	
}
