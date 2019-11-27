<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Page</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   <link href="${css}/login.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
   <li class="nav-item active">
           <h3 class="nav-link" >Hello ${uObj.userName}</h3>

    </li>
    <li class="nav-item active">
      <a class="nav-link" href="homeSeller">Home</a>
    </li> 
        <li class="nav-item"><a class="nav-link" href="getSellerLogout">Logout</a></li>
    
  </ul>
</nav>

<div align="center">
	<h2><a href="viewPoList"><button>Purchase Orders Raised</button></a></h2>
		

</body>
</html>