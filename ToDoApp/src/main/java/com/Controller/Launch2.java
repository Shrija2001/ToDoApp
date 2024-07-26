package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.NotesDao;
import com.Dao.UserDao;
import com.Modal.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Launch2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		NotesDao nDao = new NotesDao();
		ArrayList<Note> al = nDao.readAllNote(userid, con);
		
		String res = uDao.checkUser(userid, password, con);
		HttpSession session = req.getSession();
		
		if(res.equals("exists"))
		{
			session.setAttribute("al", al);
			session.setAttribute("check", userid);
			resp.sendRedirect("home.jsp");
		}
		else {
			session.setAttribute("msg", "Invalid credential");
			resp.sendRedirect("login.jsp");
		}
	}
	
	
	
}

