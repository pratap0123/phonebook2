package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.contactDao;


@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(req.getParameter("userId"));
		
		contactDao dao=new contactDao(Dbconnect.getCon());
		boolean f=dao.deleteContactById(cid);
		HttpSession session=req.getSession();
		
		if(f) {
			
			session.setAttribute("deletemsg","Deleted Successfully");
			resp.sendRedirect("viewContact.jsp");
			
		}
		else {
			
			session.setAttribute("deleteErrorMsg","Not Deleted");
			resp.sendRedirect("viewContact.jsp");
		}
		
		
		
	}

	
	
}
