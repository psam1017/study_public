<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator - JSP 페이지</title>
</head>
<body>
	<h1>JSP로 만들 페이지</h1>
	<form action="Oper" method="post">
		<p>수식을 입력하시오. 두 정수의 사칙연산 가능.</p>
		<input type="text" name="input">
		<button>확인</button>
	</form>
</body>
</html>