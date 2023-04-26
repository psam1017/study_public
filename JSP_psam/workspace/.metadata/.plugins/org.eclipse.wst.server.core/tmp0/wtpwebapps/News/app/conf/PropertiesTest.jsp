<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Properties 연계</h2>
	<hr>
	<p> 버전 : ${properties.get('version') }
	<p> url : ${properties.get('url') }
	<p> user : ${properties.get('user') }
	<p> password : ${properties.get('pw') }
	<hr>
	<p> admin : ${properties.get('admin') }
	<p> tel : ${ tel }
</body>
</html>