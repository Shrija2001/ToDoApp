package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.NotesDao;

import com.Dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class Launch1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		NotesDao nDao = new NotesDao();
		
		String res=uDao.insertUser(userid, password, email, con);
		HttpSession session = req.getSession();
		
		
		if(res.equals("insert")) {
			
			session.setAttribute("msg", "Account created");
			nDao.createNoteTable(userid, con);
			resp.sendRedirect("login.jsp");
		}
		else {
			
			session.setAttribute("msg", "Account creation failed");
			resp.sendRedirect("signup.jsp");
		}
		
		
	}
	
	
}
