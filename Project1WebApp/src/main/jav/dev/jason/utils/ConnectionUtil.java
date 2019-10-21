package dev.jason.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
public static Connection createConnection() throws ClassNotFoundException{
		
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			String conInfo = "jdbc:mariadb://gatordb.cogyw1tkustl.us-east-1.rds.amazonaws.com:3306/Project1?user=Jason&password=MDB24!169Kirby";
			
			
			Connection conn = DriverManager.getConnection(conInfo);
			//System.out.println(conn);
			
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
		
	}

}
