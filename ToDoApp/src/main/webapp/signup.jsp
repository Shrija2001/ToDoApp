<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body style="background-image: url('backgroundimg.jpeg'); background-size: cover;">



<%@ include file="msg.jsp"%>
<h1 class="text-center"><u>Sign Up Page</u></h1>

<div class="container w-50 border border-black p-4 rounded-5">
<form action="signup" method="post">

	<label class="form-label" for="uid">Enter userid</label>
	<input class="form-control" id="uid" name="userid" type="text">
	
	<label class="form-label" for="password">Enter password</label>
	<input class="form-control" id="password" name="password" type="password">
	
	<label class="form-label" for="email">Enter email</label>
	<input class="form-control" id="email" name="email"  type="email">
	
	<button class="btn btn-success">SignUp</button>
	
</form>

<a href="showloginpage" class="btn btn-info">Login</a>

</div>

</body>
</html>