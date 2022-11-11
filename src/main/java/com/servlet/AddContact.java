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
import com.entity.Contact;


@WebServlet("/addContact")
public class AddContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phon=req.getParameter("phon");
		String about=req.getParameter("about");
//		System.out.println(userId+" " +name+" "+email+" "+phon+" "+about);
		
		Contact c=new Contact(name,email,phon,about,userId);
		contactDao dao=new contactDao(Dbconnect.getCon());
		HttpSession session=req.getSession();
		boolean f=dao.saveContact(c);
		if(f==true) {
			session.setAttribute("contactMsg", "Contact saved Successfully");
			resp.sendRedirect("addContact.jsp");
			
		}
		else {
			
			session.setAttribute("contactErrorMsg", "Contact Not saved ");
			resp.sendRedirect("addContact.jsp");
		}
		
		
	}
	
	

}
