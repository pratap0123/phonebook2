
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@page import="com.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active ml-5">
			        	<a class="nav-link" href="index.jsp"><i class="fa-solid fa-house">
			        	</i>Home<span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item active ml-5">
			        	<a class="nav-link" href="addContact.jsp"><i class="fa-solid fa-calendar-plus">
			        	</i>Add Phon No</a>
			      </li>
		      
			      <li class="nav-item active ml-5">
			        	<a class="nav-link disabled" href="viewContact.jsp"><i class="fa-solid fa-eye">
			        	</i>View Contact</a>
			      </li>
			      <li class="nav-item active ml-5">
			        	<a class="nav-link disabled">
			        	<i>
			        		<%
					         Date date = new Date();
					         out.print( "<p align = \"center\">" +date.toString()+"</p>");
     						 %>
			        	</i>
			        	</a>
			      </li>
		    </ul>
		    		<%
					User user=(User)session.getAttribute("success");
					
					if(user==null)
					{
					%>
						<form class="form-inline my-2 my-lg-0">
			     		<a href="login.jsp" class="btn btn-success"><i class="fa-solid fa-boxes-packing"></i>Login</a>
			     		<a href="register.jsp" class="btn btn-warning ml-2" ><i class="fa-solid fa-user"></i>Register</a>
		    			</form>
						
					<%
					}
					else
					{
					%>
						<form class="form-inline my-2 my-lg-0">
			     		<button class="btn btn-success"><%=user.getName() %></button>
			     		<a data-toggle="modal" data-target="#exampleModalCenter" href="logout" class="btn btn-danger ml-2">Logout</a>
			     		
		    			</form>
					<%
					}
					%>
		    
	  </div>
	  
	  
	  <!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Logout Page</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">
        <h5>Do You Want to Logout...</h5>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a href="logout" class="btn btn-primary">Logout</a>
        
      </div>
      <div class="modal-footer">
        </div>
    </div>
  </div>
</div>
	  
	  
</nav>