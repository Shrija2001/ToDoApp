<%@page import="com.Modal.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-image: url('backgroundimg3.jpeg'); background-size: cover;">
<%
String check=(String)session.getAttribute("check");
if(check!=null)
{
	
	String note = request.getParameter("note");
	String adddate = request.getParameter("adddate");
	
%>

<h1 class="text-center">Edit Note</h1>

<div class="container w-50">
<form action="editnote">
	
	<textarea rows="" cols="" class="form-control" name="note"><%=note %></textarea>
	<input type="hidden" name="userid" value="<%=check %>">
	<input type="hidden" name="oldnote" value=<%=note %>>
	<button class="btn btn-success">Done</button>
</form>
</div>
<%
}
else
{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>