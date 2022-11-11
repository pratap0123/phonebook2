package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.conn.Dbconnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User(name,email,password);
		UserDao dao=new UserDao(Dbconnect.getCon());
		boolean f=dao.userRegister(user);
		
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("successmsg","Successfully registered");
			res.sendRedirect("register.jsp");
//			System.out.println("Successfully register");
		}
		else {
			session.setAttribute("errormsg","faild to register");
//			System.out.println("faild to register");
		}
		
	}

	
}
