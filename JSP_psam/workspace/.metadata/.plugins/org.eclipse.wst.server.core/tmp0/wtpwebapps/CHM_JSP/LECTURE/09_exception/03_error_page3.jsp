<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception2</title>
</head>
<body>
	<!-- error_process에서 별도로 에러 페이지를 지정하지 않았으므로 web.xml에서 지정한 default 에러 페이지로 이동한다. -->
	<form action="03_error_page3_process.jsp">
		숫자 1 : <input type="text" name="num1">
		<br>
		숫자 2 : <input type="text" name="num2">
		<br>
		<input type="submit" value="나눗셈">
	</form>
</body>
</html>