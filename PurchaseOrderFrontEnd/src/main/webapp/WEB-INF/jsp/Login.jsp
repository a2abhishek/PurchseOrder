<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <link href="${css}/login.css" rel="stylesheet">
</head>
<body>
	<!-- 	<h1 style="text-align: center;font-family: verdana;color: #fff;">
			${msg}
		</h1>
	 -->	
		<div class="login">
		<h1>Login</h1>
	    	<form method="post" action="signIn">
	    	<input type="email" name="email" placeholder="Email" required="required" />
	        <input type="password" name="password" placeholder="Password" required="required" />
	        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
	        </form>
	        
	        <form method="post" action="getRegister">
	        <button type="submit" class="btn btn-primary btn-block btn-large">Register</button>
    	</form>
		</div>
		
</body>
</html>