<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
	<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file ="/WEB-INF/css/Signup.css"%>

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post" style="border: 1px solid #ccc">
		<c:if test="${alert !=null}">
<h3 class="alert alertdanger">${alert}</h3>
</c:if>
		<div class="container">
			
			<label for="username"><b>Username</b></label> 
			<input type="text"
				placeholder="Enter username" name="username" required>
			<label for="email"><b>Email</b></label> 
			<input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <label
				for="rp"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" name="rp"
				required>

			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>
</body>
</html>