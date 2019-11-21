<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
	<script type="text/javascript" src="${js}/addUser.js"></script>
	<script type="text/javascript" src="${js}/checkName.js"></script>
			
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
		<h1 style="text-align: center;font-family: verdana;color: green">
			${myData}
		</h1>
		
		<hr/>
		
		<div align="center">
			<h1>${formLabel}</h1>
			<f:form action="${path}/registerUser" method="post" modelAttribute="userObj">
			<f:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>User Id : </td>
					<td><f:input path="id" id ="userid"/>
					<f:errors path="id" cssClass = "error" /></td>
				</tr>
				<tr>
					<td>User Name : </td>
					<td><f:input path="name" id="username"/>
					<f:errors path="name" cssClass = "error" /></td>
				</tr>
				
			
				<c:if test="${userObj.password eq null || empty userObj.password}">
					<tr>
						<td>Password : </td>
						<td><f:password path="password" id = "password"/>
						<f:errors path="password"/></td>
					</tr>
				</c:if>	
				
				<tr>
					<td>Gender : </td>
					<td><f:input path="gender" id="gender"/>
					<f:errors path="gender"/></td>
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