<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include  file="component/allCss.jsp"%>
</head>
<body style="background-color:#7169e0;">
<%@include file="component/navbar.jsp" %>
<div class="container-fluid"></div>
	<div class="row p-2">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
					<h4 class="text-success text-center">Registration Page</h4>
					<%
					String str=(String)session.getAttribute("successmsg");
					String strr=(String)session.getAttribute("errormsg");
					if(str!=null){
					%>
						<h1 class="text-success text-center"><%=str %></h1>
					<%
					session.removeAttribute("successmsg");
					}
					if(strr!=null){
						%>
						<p class="text-danger"><%=strr %></p>
					<%
					session.removeAttribute("errormsg");
					}
					%>
					<form action="register" method="post">
							
							<div class="form-group">
							    <label for="exampleInputEmail1">Enter Name</label>
							    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
							     placeholder="Enter Name">
							    
						 	 </div>
							
							  <div class="form-group">
								    <label for="exampleInputEmail1">Enter Email address</label>
								    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
								     placeholder="Enter email">
								    
							  </div>
							  <div class="form-group">
								    <label for="exampleInputPassword1">Password</label>
								    <input name="password" type="password" class="form-control" id="exampleInputPassword1" 
								    placeholder="Password">
							  </div>
							  <div class="text-center mt-2">
							  		<button type="submit" class="btn btn-primary">Register</button>
							  </div>
							 
						  		
						</form>
				
				</div>
			</div>
		</div>
	
	</div>
</div>
<div style="margin-top: 160px">
	<%@include file="component/footer.jsp" %>
</div>
</body>
</html>