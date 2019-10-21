package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.jason.entities.User;
import dev.jason.utils.ConnectionUtil;

public class UserDAOjdbc implements UserDAO{
	
	private static UserDAO udao;
	
	private UserDAOjdbc() {};
	
	public static UserDAO getUserDAOjdbc() {
		
		if(udao ==null) {
			udao = new UserDAOjdbc();
		}
		return udao;
		
	}

	public User createUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "INSERT INTO Project1.reimbursementUser values (?,?,?,?)";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, 0);
	    	   ps.setString(2, user.getUsername());
	    	   ps.setString(3, user.getPassword());
	    	   ps.setString(4, user.getEmployee_position());
	    	   
	    	   ps.execute();
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public User getUserById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project1.reimbursementUser where id = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   User user = new User();
	    	   
	    	   user.setId(rs.getInt("id"));
	    	   user.setUsername(rs.getString("username"));
	    	   user.setPassword(rs.getString("password"));
	    	   user.setEmployee_position(rs.getString("employee_position"));
	    	   
	    	   return user;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public User getUserByUsernameAndPassword(String username, String Password) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project1.reimbursementUser where username = ? AND  password=?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setString(1, username);
	    	   ps.setString(2, Password);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   System.out.println("Id is "+rs.getInt("id"));
	    	   
	    	   User user = new User();
	    	   
	    	   user.setId(rs.getInt("id"));
	    	   user.setUsername(rs.getString("username"));
	    	   user.setPassword(rs.getString("password"));
	    	   user.setEmployee_position(rs.getString("employee_position"));
	    	   
	    	   return user;
	    	   
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public User updateUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   String sql = "UPDATE Project1.reimbursementUser SET id = ?, username = ?, password = ?, employee_position = ? WHERE id = ?";
	    	   
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, user.getId());
	    	   ps.setString(2, user.getUsername());
	    	   ps.setString(3, user.getPassword());
	    	   ps.setString(4, user.getEmployee_position());
	    	   ps.setInt(5, user.getId());
	    	   
	    	   ps.execute();
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public User deleteUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE from Project1.reimbursementUser WHERE id=?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, user.getId());
	    	   ps.execute();
	    	   
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

}
