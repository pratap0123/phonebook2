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



@WebServlet("/updateContact")
public class EditContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid=Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phon=req.getParameter("phon");
		String about=req.getParameter("about");
		System.out.println(name);
		System.out.println(email);
		System.out.println(phon);
		System.out.println(about);
		
		Contact c=new Contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phon);
		c.setAbout(about);
		contactDao dao=new contactDao(Dbconnect.getCon());
		boolean f=dao.updateContact(c);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("editMsg", "Your Contact updated  Successfully");
			resp.sendRedirect("viewContact.jsp");
			
		}
		else {
			
			session.setAttribute("editErrorMsg", "Your Contact Not Updated ");
			resp.sendRedirect("editContact.jsp?cid="+cid);
		}
		
		
		
	}

	
	
}
