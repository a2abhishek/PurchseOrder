<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
	<!-- <script type="text/javascript" src="${js}/addUser.js"></script>
	<script type="text/javascript" src="${js}/checkName.js"></script>
		 -->	
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
		
		<hr/>
		
		<div align="center">
			<h1>Registration</h1>
			<f:form action="registerUser" method="post" modelAttribute="userObj">
			<table>
				<tr>
					<td>Name : </td>
					<td><f:input path="userName" id="userName"/>
				</tr>
				
				<tr>
					<td>Email : </td>
					<td><f:input path="userEmail" id = "email"/>
				</tr>
				<tr>
					<td>Mobile Number : </td>
					<td><f:input path="userPhone" id = "phone"/>
				</tr>
				<tr>
					<td>Password : </td>
					<td><f:password path="userPass" id = "pass"/>
				</tr>
				<tr>
					<td>Address : </td>
					<td><f:input path="userAddress" id = "addr"/>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" class="submitForm" value="${btnLabel}" onclick="submitForm()"/>
					</td>
				</tr>
			</table>
			</f:form>
		</div>
		
	</body>
</html>