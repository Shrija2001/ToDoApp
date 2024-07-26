package com.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection con;
	
	public static Connection getCon() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/todoapp";
			con=DriverManager.getConnection(url,"root", "");
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			return con;
		} 
	}
	
	
}