<%@page import="com.Modal.Note"%>
<%@page import="com.Dao.NotesDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
        .center-button {
           
            
        }
    </style>
</head>
<body style="background-image: url('backgroundimg4.jpeg'); background-size: cover;">

<%
String check=(String)session.getAttribute("check");
if(check!=null)
{
%>

<p>hello <%=check %></p>
<h1 class="text-center"><u>Dashboard</u></h1>

<a class="btn btn-info center-button" href="addnote.jsp" >Add note</a>

<a href="logout" class="btn btn-danger">Logout</a>


<%
ArrayList<Note> al=(ArrayList<Note>) session.getAttribute("al");
if(al!=null)
{
for(Note n:al)
{
%>

<div class="container w-25 border rounded-5 mb-5 p-4 text-center">
<h4 class="display-4"><%=n.getNote() %></h4>
<p><%=n.getAddDate() %></p>
<p><%=n.getEditDate() %></p>
<div class="container">
<div class="row">
<form action="deleteNote" class="col-6">
<input type="hidden" name="userid" value="<%=check %>">
<input type="hidden" name="note" value="<%=n.getNote() %>">
<button class="btn btn-danger btn-sm">Delete</button>
</form>
</div>
</div>

<div class="container">
<div class="row">
<form action="editnote.jsp" class="col-6">
<input type="hidden" name="userid" value="<%=check %>">
<input type="hidden" name="note" value="<%=n.getNote() %>">
<button class="btn btn-primary btn-sm">Edit Note</button>
</form>
</div>
</div>
</div>
<%} }%>

<% 
}
else
{
	response.sendRedirect("login.jsp");	
}

%>





</body>
</html>