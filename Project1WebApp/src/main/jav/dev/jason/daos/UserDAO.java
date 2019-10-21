package dev.jason.daos;

import dev.jason.entities.User;

public interface UserDAO {

	//create
	User createUser(User user);
	
	//read
	User getUserById(int id);
	User getUserByUsernameAndPassword(String username, String Password);
	
	//update
	User updateUser(User user);
	
	//delete
	User deleteUser(User user);

}
