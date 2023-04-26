<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception2</title>
</head>
<body>
	<!-- error_process에서 직접 설정한 에러페이지로 이동하게 된다. -->
	<form action="02_error_page2_process.jsp">
		숫자 1 : <input type="text" name="num1">
		<br>
		숫자 2 : <input type="text" name="num2">
		<br>
		<input type="submit" value="나눗셈">
	</form>
</body>
</html>