package dev.jason.daotest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import dev.jason.daos.ReimbursementDAO;
import dev.jason.daos.ReimbursementDAOjdbc;
import dev.jason.entities.Reimbursement;
import junit.framework.Assert;
import junit.framework.TestCase;



public class ReimbursementDAOtest  {
	public static ReimbursementDAO rdao = ReimbursementDAOjdbc.getReimbursementDAOjdbc();
	
	/*
	@Test
	public void createReimbursement(){
		
		Reimbursement reimbursement = new Reimbursement(0,"Adam","Xbox360",250.00,"Red Ring of Death",2,"pending","waiting to be approved/denied");
		rdao.createReimbursement(reimbursement);
		fail("Not yet implemented");
		
	}
	*/
	
	@Test
	public void getReimbursementById(){
		
		Reimbursement reimbursement = rdao.getReimbursementById(1);
		
		//Assert.assertEquals("Thomas", reimbursement.getSender());
		//Assert.assertEquals("fortnite", reimbursement.getItem());
		//Assert.assertEquals(3, reimbursement.getSubmitterID());
		
		//System.out.println(reimbursement.getItem());
		
		//fail("Not yet implemented");
		
	}
	/*
	@Test
	public void getFirstPendingReimbursement(){
		Reimbursement reimbursement = rdao.getFirstPendingReimbursement();
		System.out.println(reimbursement.getItem());
		
		reimbursement.setStatus("approved");
		rdao.updateReimbursement(reimbursement);
		
		Reimbursement check = rdao.getFirstPendingReimbursement();
		System.out.println(check.getItem());
		fail("Not yet implemented");
		
	}
	*/
	
	@Test
	public void getAllReimbursements(){
		Set<Reimbursement> reimbursements = rdao.getAllReimbursements();
		Assert.assertEquals(6, reimbursements.size());
		Assert.assertEquals(true, reimbursements.contains(rdao.getReimbursementById(3)));
		Assert.assertEquals(true, reimbursements.contains(rdao.getReimbursementById(5)));
		Assert.assertEquals(true, reimbursements.contains(rdao.getReimbursementById(1)));
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void updateReimbursement(){
		
		Reimbursement reimbursement = rdao.getReimbursementById(3);
		reimbursement.setStatus("approved");
		reimbursement.setSender("Joe");
		
		rdao.updateReimbursement(reimbursement);
		
		Reimbursement check = rdao.getReimbursementById(3);
		
		Assert.assertEquals("approved", check.getStatus());
		Assert.assertEquals("Joe", check.getSender());
		
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void deleteReimbursement(){
		
		Reimbursement reimbursement = rdao.getReimbursementById(6);
		rdao.deleteReimbursement(reimbursement);
		
		Reimbursement check = rdao.getReimbursementById(6);
		Assert.assertEquals(null, check);
		//fail("Not yet implemented");
		
	}
	

}
