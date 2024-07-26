package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao  {
	String res = "";

	public String insertUser(String userid, String password, String email, Connection con) {
		
		try {
		String sql = "insert into userinfo values(?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, password);
		ps.setString(3, email);
		
		int r = ps.executeUpdate();
		if(r==1){
			
			res="insert";
		}
		else {
			
			res="failed";
		}
			
	}
	catch(Exception o) {
		res="failed";
	}
	finally {
		return res;
	}
	}
	
	public String checkUser(String userid, String password, Connection con) {
		
		try {
			String sql = "select * from userinfo where userid=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			boolean flag=false;
			while(rs.next()) {
				flag=true;
			}
			if(flag) {
				res="exists";
			}
			else {
				res="failed";
			}
		}
		catch(Exception e) {
			res="failed";
		}
		finally {
			return res;
		}
	}
	
}



