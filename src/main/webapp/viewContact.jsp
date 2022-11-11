<%@page import="com.entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.contactDao"%>
<%@page import="com.conn.Dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact view</title>
<%@include  file="component/allCss.jsp"%>
<style>
.crd-ho:hover{
	
		background-color:gray;
		color:Lime;
}

</style>
</head>
<body style="background-color:#c4f551;">
<%@include file="component/navbar.jsp" %>
	<%
	if(user==null) 
	{
		session.setAttribute("error","Please Login");
		response.sendRedirect("login.jsp");
	
	}
	%>
	
	<%
	
	String msg=(String)session.getAttribute("editMsg");
	if(msg!=null)
	{
	%>
		
		<div class="alert alert-success" role="alert"><%=msg%></div>
	<% 
		session.removeAttribute("editMsg");
	}
	
	%>
	
	
	
	<% 
	String dmsg=(String)session.getAttribute("deletemsg");
	if(dmsg!=null)
	{
	%>
		
		<div class="alert bg-success text-center alert-success" role="alert"><h1><%=dmsg%></h1></div>
	<% 
		session.removeAttribute("deletemsg");
	}
	%>

			
	
	<div class="container">
		<div class="row p-5">
			
			
			<%
			if(user!=null)
			{
				contactDao dao=new contactDao(Dbconnect.getCon());
				List<Contact> contact=dao.getAllContact(user.getId());
				for(Contact c:contact)
				{
			%>
				<div class="col-md-3">
					<div class="card crd-ho">
						<div class="card-body">
							<p>
							<h5>
							Name:
							<%=c.getName() %>
							</h5>
							<p>
							Phone No:
							<%=c.getPhone() %>
							</p>
							<p>
							Email:
							<%=c.getEmail() %>
							</p>
							<p>
							About:
							<%=c.getAbout() %>
							</p>
							<div class="text-center">
								<a href="editContact.jsp?userId=<%=c.getId()%>" class="btn btn-success btn-sm text-white">Edit</a>
								<a href="deleteContact?userId=<%=c.getId()%>"class="btn btn-danger btn-sm text-white">Delete</a>
							</div>
							
						</div>
						
					</div>
				</div>
			
				
			<%
			}
			}
			%>
				
				
			
			
		
		</div>
	
	</div>
	
	
	<div style="margin-top: 247px">
	<%@include file="component/footer.jsp" %>
	</div>
	
</body>
</html>