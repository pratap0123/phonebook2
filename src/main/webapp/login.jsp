<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include  file="component/allCss.jsp"%>
</head>
<body style="background-color:#7169e0;">
<%@include file="component/navbar.jsp" %>
<div class="container-fluid">
	<div class="row p-2">
		<div class="col-md-4 offset-md-3">
			<div class="card">
				<div class="card-body">
					<h4 class="text-success text-center">Login Page</h4>
					
					<%
					String invalid=(String)session.getAttribute("error");
					
					if(invalid!=null)
					{%>
						<p class="text-danger text-center"><%= invalid%></p>
						
					<%
					session.removeAttribute("error");
					}
					%>
					
					<%
					String log=(String)session.getAttribute("log");
					
					if(log!=null)
					{%>
						<h1 class="text-success text-center"><%= log%></h1>
						
					<%
					session.removeAttribute("log");
					}
					%>
					<form action="Login" method="post">
							
						  <div class="form-group">
							    <label for="exampleInputEmail1">Email address</label>
							    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
							     placeholder="Enter email">
							    
						  </div>
						  <div class="form-group">
							    <label for="exampleInputPassword1">Password</label>
							    <input name="password" type="password" class="form-control" id="exampleInputPassword1" 
							    placeholder="Password">
						  </div>
						  <div class="text-center mt-2">
						  		<button type="submit" class="btn btn-primary">Login</button>
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