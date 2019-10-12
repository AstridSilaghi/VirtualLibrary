<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body style="background-color:(40, 149, 69);">
<h3 class="style2" align="right">User name: 
</h3>
<h3 class="style2" align="right">
<%
	out.print(request.getAttribute("username"));
%>
</h3>

<%
	out.print("Your reservation details:");
	out.print("\nTitle  " + request.getAttribute("title"));
	out.print("\nAuthor  " + request.getAttribute("author"));
%>

</body>
</html>