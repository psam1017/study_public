<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<form method="post" action="insert01_process.jsp">
		<strong>한글 인코딩을 하지 않았으니 주의!</strong>
		<p> 아이디 : <input type="text" name="id">
		<p> 비밀번호 : <input type="password" name="password">
		<p> 이름 : <input type="text" name="name">
		<p> <input type="submit" value="전송">
	</form>
</body>
</html>