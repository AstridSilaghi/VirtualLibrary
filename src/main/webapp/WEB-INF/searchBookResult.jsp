<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Funky Library</title>
</head>
<body>
<h3>
	
</h3>
<%
	out.print("Title is:" + request.getAttribute("title"));
	out.print("\nAuthor is:" + request.getAttribute("author"));
	out.print("\nStatus is:" + request.getAttribute("status"));
%>

<p id="title">

<form action="reserveBook">
<input type="submit" value="Reserve the book for 30 days">  


</form>
<form action="toHomePage">
<input type="submit" value="Back to home page. Thank you for interest.">
</form>
</body>
</html>