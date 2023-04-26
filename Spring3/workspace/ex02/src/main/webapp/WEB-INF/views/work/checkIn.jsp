<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
</head>
<body>
	<form action="/ex02/getToWork" name="checkInForm">
		<input type="text" name="name">
		<br>
		<button type="submit">출근</button>
		<button type="button">퇴근</button>
	</form>
</body>
<script>
	const form = checkInForm;
	const button = document.querySelector("button[type='button']");
	
	form.setAttribute("action", "/ex02/getToWork");
	
	button.addEventListener("click", function(){
		form.setAttribute("action", "/ex02/leaveWork");
		form.submit();
	});
</script>
</html>