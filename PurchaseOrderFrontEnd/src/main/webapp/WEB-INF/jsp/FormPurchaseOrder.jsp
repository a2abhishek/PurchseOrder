  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PurchaseOrder Form</title>
	</head>
<body>
	<form>
		<table>
		
			<tr>
				<td>
					Buyer's Name:
					<input type="text" value="${uObj.userName}">
				</td>
			</tr>
			
			<tr>
				<td>
					Product Name:
					<input type="text">
				</td>
			</tr>
			
			<tr>
				<td>
					Product Quantity:
					<input type="text">
				</td>
			</tr>
			
			<tr>
				<td>
					Expected date of delivery:
					<input type="date">
				</td>
			</tr>
			
			<tr>
				<td>
					Delivery Address: 
					<input type="textarea">
				</td>
			</tr>
			
			<tr>
				<td>
					Order placed on:
					<input type="date">
				</td>
			</tr>
			
			<tr>
			<td>
				<input type="submit" value="Generate Purchase Order">
			</td>
			</tr>
			
		</table>
	</form>
</body>
</html>