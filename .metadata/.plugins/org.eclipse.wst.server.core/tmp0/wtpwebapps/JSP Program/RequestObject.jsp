<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Request is a Implicit Object in JSP</title>
</head>
<body bgcolor="#E6E6FA" align="center" margin-top="50px">

		<h1>Request Implicit Object</h1>
		Request User Agent: <%=request.getHeader("User-Agent")%> <br><br>
		Request User Language: <%=request.getLocale() %>
</body>
</html>