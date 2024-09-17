<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
	<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file ="/WEB-INF/css/Login.css"%>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
	<c:if test="${alert !=null}">
<h3 class="alert alertdanger">${alert}</h3>
</c:if>
		

		<div class="container">
			<label for="username"><b> Username </b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
			
			</div>
	</form>
	<form action="register" method="post">
	<button type="submit">Signup</button>
	</form>
	
</body>
</html>