<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
	 <link href="${css}/register.css" rel="stylesheet">
	<style> 
		.error {
			color:#ff0000;
		}
		.errorblock {
        color: #000;
        background-color: #fff;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
     }
	</style>
	<script
		  src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		  integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
		  crossorigin="anonymous">
	</script>
	</head>
	<body>
	<div class="login">
        <h1> Registration Form </h1>
			<f:form action="registerUser" method="post" modelAttribute="userObj" class="was-validated">
			<div class="form-group">
				<table>
					<tr>
						<td><label for="userName" style="color: #fff;">Name :</label></td>
                    	<td><f:input type="text"  path="userName" name="userName" id="userName" size="50" placeholder="Enter User name"  /></td>
					</tr>
					
					<tr>
						<td><label for="email" style="color: #fff;">Email :</label></td>
						<td><f:input type="email" path="userEmail" name="email" id="email" size="50"  /></td>
					</tr>
					<tr>
					 	<td><label for="phone" style="color: #fff;">Mobile :</label></td>
	                    <td><f:input type="text" path="userPhone" name="phone" id="phone" pattern="[0-9]{10}"  /></td>
					</tr>
					<tr>
					<tr>
	                    <td><label for="password" style="color: #fff;">Password :</label></td>
	                    <td><f:input type="password" path="userPass" name="password" id="password" size="50"  /></td>
					<tr>
						 <td><label for="addr" style="color: #fff;">Address :</label></td>
	                    <td><f:input type="textarea" path="userAddress" name="addr" id="addr" /></td>
					</tr>
					<tr>
						<td></td>
	                    <td><button type="submit" class="btn btn-primary btn-block btn-large">Submit</button></td>
					</tr>
				</table>
			</div>
			</f:form>
		</div>
	</body>
</html>