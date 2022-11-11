package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		System.out.println(email+" "+pass);
		UserDao dao=new UserDao(Dbconnect.getCon());
		User u=dao.loginUser(email,pass);
		
		HttpSession session=req.getSession();
		if(u!=null) {
			session.setAttribute("success",u);
			resp.sendRedirect("index.jsp");
//			System.out.println("User is Availalble");
		}
		else {
			session.setAttribute("error","Invalid Email and Password");
			resp.sendRedirect("login.jsp");
//			System.out.println("User is Not Availalble");
		}
	}
	
	
}
