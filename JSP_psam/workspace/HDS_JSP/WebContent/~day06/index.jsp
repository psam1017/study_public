<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 페이지</title>
</head>
<body>
	<!-- action을 사용하여 서블릿으로 이동하고, method로 get 또는 post 선택 -->
	<h1>JSP로 만든 페이지</h1>
	<form action="Hello"  method="post">
		<p>서블릿으로 이동</p>
		<button>이동</button>
	</form>
</body>
</html>