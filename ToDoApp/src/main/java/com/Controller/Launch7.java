package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.NotesDao;
import com.Modal.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editnote")
public class Launch7 extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid"); 
		String note = req.getParameter("note");
		String oldnote = req.getParameter("oldnote");
		

		Connection con = ConnectionFactory.getCon();
		NotesDao nDao = new NotesDao();
		
		nDao.editNote(userid, oldnote, note, con);
		HttpSession session = req.getSession();
		
		ArrayList<Note> al = nDao.readAllNote(userid, con);
		session.setAttribute("al", al);
		
		resp.sendRedirect("home.jsp");
		
		
	}
	
}
