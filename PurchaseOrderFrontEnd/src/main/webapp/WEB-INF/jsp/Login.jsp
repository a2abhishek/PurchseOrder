<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
		<h1 style="text-align: center;font-family: verdana;color: green">
			${msg}
		</h1>
		
		<hr/>
		
		<h1>Sign In</h1>
		<form action="signIn" method="post">
			<table>
				<tr>
					<td>Email : </td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Sign In"/></td>
				</tr>
			</table>
		</form>
		
</body>
</html>