package dev.jason.daotest;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jason.daos.UserDAO;
import dev.jason.daos.UserDAOjdbc;
import dev.jason.entities.User;
import junit.framework.Assert;
import junit.framework.TestCase;

public class UserDAOtest{
	
	public static UserDAO udao = UserDAOjdbc.getUserDAOjdbc();
	
	/*
	@Test
	public void createUser() {
		
		User user = new User(0,"vikingking24","ffssll90","employee");
		
		user = udao.createUser(user);
		
		
		//Assert.assertEquals(user, udao.getUserById(6));
		fail("Not yet implemented");
	}
	
	*/
	
	
	@Test
	public void getUserById(){
		User user = udao.getUserById(3);
		
		Assert.assertEquals("punchingmicrobe892", user.getUsername());
		Assert.assertEquals("minecon386", user.getPassword());
		Assert.assertEquals("employee", user.getEmployee_position());
		
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void getUserByUsernameAndPassword(){
		User user = udao.getUserByUsernameAndPassword("punchingmicrobe892", "minecon386");
		
		
		Assert.assertEquals(3, user.getId());
		Assert.assertEquals("employee", user.getEmployee_position());
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void updateUser(){
		
		User user = udao.getUserById(1);
		
		user.setPassword("123456");
		user.setEmployee_position("manager");
		
		udao.updateUser(user);
		fail("Not yet implemented");
		
	}
	
	@Test
	public void deleteUser(){
		User user1 = udao.getUserById(6);
		//User user2 = udao.getUserById(7);
		
		udao.deleteUser(user1);
		//udao.deleteUser(user2);
		
		//fail("Not yet implemented");
		
	}
	
	
	
	

}

	


