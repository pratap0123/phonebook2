<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contacts</title>
<%@include  file="component/allCss.jsp"%>
</head>
<body style="background-color:#7169e0;">
<%@include file="component/navbar.jsp" %>


	<%
	if(user==null) 
	{
		session.setAttribute("error","Please Login");
		response.sendRedirect("login.jsp");
	
	}
	%>
<div class="container-fluid"></div>
	<div class="row p-2">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
					<h4 class="text-success text-center">Add Contact Page</h4>
					
					
					<%
					String str=(String)session.getAttribute("contactMsg");
					String strr=(String)session.getAttribute("contactErrorMsg");
					if(str!=null){
					%>
						<h1 class="text-success text-center"><%=str %></h1>
					<%
					session.removeAttribute("contactMsg");
					}
					if(strr!=null){
						%>
						<p class="text-danger"><%=strr %></p>
					<%
					session.removeAttribute("contactErrorMsg");
					}
					%>
					
					<form action="addContact" method="post">
							
							
							<%
								if(user!=null)
								{%>
									<input type="hidden" value="<%= user.getId()%>" name="userId">
								<%}
							%>
							<div class="form-group">
							    <label for="exampleInputEmail1">Enter Name</label>
							    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
							     placeholder="Enter Name">
							    
						 	 </div>
							
							  <div class="form-group">
								    <label for="exampleInputEmail1">Email address</label>
								    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
								     placeholder="Enter email">
								    
							  </div>
							  <div class="form-group">
								    <label for="exampleInputPassword1">Enter Phone no</label>
								    <input name="phon" type="number" class="form-control" id="exampleInputPassword1" 
								    placeholder="Enter Phone No">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Enter About</label>
							    <input name="about" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
							     placeholder="Enter About">
							    
						 	 </div>
							  <div class="text-center mt-2">
							  		<button type="submit" class="btn btn-primary">Save Contact</button>
							  </div>
							 
						  		
						</form>
				
				</div>
			</div>
		</div>
	
	</div>
</div>
<div style="margin-top: 247px">
	<%@include file="component/footer.jsp" %>
	</div>
</body>
</html>