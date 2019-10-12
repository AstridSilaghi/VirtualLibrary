<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Funky Library</title>
<style>
.style1{
	background-image: url("https://i.pinimg.com/736x/8a/4e/1e/8a4e1e8d6b340da246f22c5fac5b655e.jpg");
	background-repeat: no-repeat;
	opacity: 0.5;
	color: red;
	margin: 20px;
	padding: 20px;

}
.style2{
	opacity: 1.0;
	color: red;
	margin: 20px;
	padding: 20px;

}
</style>
</head>

<body style="background-color:(40, 149, 69);">
<h3 class="style2" align="right">User name: 
</h3>
<h3 class="style2" align="right">
<%
	out.print(request.getAttribute("username"));
%>
</h3>
<br>
<h1 class="style2">Never trust anyone who has not brought a book with them. </h1>
<form class="style2" action="searchBook">
	<p> Remember the title? Search for it </p> <br />
	<input placeholder="Enter book title" type="text" value="" name="title">
	<input type="submit" value="Search book">
</form>
</body>
</html>