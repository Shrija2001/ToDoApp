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

@WebServlet("/addnote")
public class Launch5 extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String note = req.getParameter("note");
		
		
		Connection con = ConnectionFactory.getCon();
		NotesDao nDao = new NotesDao();
		
		nDao.addNote(userid, note, con);
		
		ArrayList<Note> al = nDao.readAllNote(userid, con);
		HttpSession session = req.getSession();
		session.setAttribute("al", al);
		resp.sendRedirect("home.jsp");
		
	}
}
