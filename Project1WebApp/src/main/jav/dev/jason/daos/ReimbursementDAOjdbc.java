package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import dev.jason.entities.Reimbursement;
import dev.jason.entities.User;
import dev.jason.utils.ConnectionUtil;

public class ReimbursementDAOjdbc implements ReimbursementDAO{
	
	private static ReimbursementDAO rdao;
	
	private ReimbursementDAOjdbc() {};
	
	public static ReimbursementDAO getReimbursementDAOjdbc() {
		
		if(rdao ==null) {
			rdao = new ReimbursementDAOjdbc();
		}
		return rdao;
		
	}

	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "INSERT INTO Project1.reimbursement values (?,?,?,?,?,?,?,?)";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, 0);
	    	   ps.setString(2, reimbursement.getSender());
	    	   ps.setString(3, reimbursement.getItem());
	    	   ps.setDouble(4, reimbursement.getCost());
	    	   ps.setString(5, reimbursement.getReason());
	    	   ps.setInt(6, reimbursement.getSubmitterID());
	    	   ps.setString(7, reimbursement.getStatus());
	    	   ps.setString(8, reimbursement.getManagerComment());
	    	   
	    	   ps.execute();
	    	   return reimbursement;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public Reimbursement getReimbursementById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project1.reimbursement where id = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   Reimbursement reimbursement = new Reimbursement();
	    	   
	    	   reimbursement.setId(rs.getInt("id"));
	    	   reimbursement.setSender(rs.getString("sender"));
	    	   reimbursement.setItem(rs.getString("item"));
	    	   reimbursement.setCost(rs.getDouble("cost"));
	    	   reimbursement.setReason(rs.getString("reason"));
	    	   reimbursement.setSubmitterID(rs.getInt("submitterID"));
	    	   reimbursement.setStatus(rs.getString("status"));
	    	   reimbursement.setManagerComment(rs.getString("managerComment"));
	    	   
	    	   return reimbursement;
	    	   
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	@Override
	public Reimbursement getFirstPendingReimbursement() {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project1.reimbursement where status = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setString(1, "pending");
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   Reimbursement reimbursement = new Reimbursement();
	    	   
	    	   reimbursement.setId(rs.getInt("id"));
	    	   reimbursement.setSender(rs.getString("sender"));
	    	   reimbursement.setItem(rs.getString("item"));
	    	   reimbursement.setCost(rs.getDouble("cost"));
	    	   reimbursement.setReason(rs.getString("reason"));
	    	   reimbursement.setSubmitterID(rs.getInt("submitterID"));
	    	   reimbursement.setStatus(rs.getString("status"));
	    	   reimbursement.setManagerComment(rs.getString("managerComment"));
	    	   
	    	   return reimbursement;
	    	   
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}
	

	public Set<Reimbursement> getAllReimbursements() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * from Project1.reimbursement";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   Set<Reimbursement> reimbursements = new HashSet<Reimbursement>();
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   while(rs.next()){
	    		   Reimbursement reimbursement = new Reimbursement();
		    	   
	    		   reimbursement.setId(rs.getInt("id"));
		    	   reimbursement.setSender(rs.getString("sender"));
		    	   reimbursement.setItem(rs.getString("item"));
		    	   reimbursement.setCost(rs.getDouble("cost"));
		    	   reimbursement.setReason(rs.getString("reason"));
		    	   reimbursement.setSubmitterID(rs.getInt("submitterID"));
		    	   reimbursement.setStatus(rs.getString("status"));
		    	   reimbursement.setManagerComment(rs.getString("managerComment"));
		    	   
		    	   reimbursements.add(reimbursement);
	    	   }
	    	   return reimbursements;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   String sql = "UPDATE Project1.reimbursement SET id = ?, sender = ?, item = ?, cost = ?, reason = ?, submitterID = ?, status = ?, managerComment = ? WHERE id = ?";
	    	   
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, reimbursement.getId());
	    	   ps.setString(2, reimbursement.getSender());
	    	   ps.setString(3, reimbursement.getItem());
	    	   ps.setDouble(4, reimbursement.getCost());
	    	   ps.setString(5, reimbursement.getReason());
	    	   ps.setInt(6, reimbursement.getSubmitterID());
	    	   ps.setString(7, reimbursement.getStatus());
	    	   ps.setString(8, reimbursement.getManagerComment());
	    	   ps.setInt(9, reimbursement.getId());
	    	   
	    	   ps.execute();
	    	   return reimbursement;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	
	public Reimbursement deleteReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE from Project1.reimbursement WHERE id=?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, reimbursement.getId());
	    	   ps.execute();
	    	   
	    	   return reimbursement;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return null;
	}

	

	

}
