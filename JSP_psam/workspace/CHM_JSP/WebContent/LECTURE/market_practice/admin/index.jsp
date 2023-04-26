<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">관리자 메인</h1>
		</div>
	</div>
	
	<div class="container">
		<h2 class="alert alert-danger"><%= session.getAttribute("sessionAdminName") %>님 환영합니다.</h2> 
		<h2 class="alert alert-danger">로그인 시간은 <%= (String)session.getAttribute("sessionAdminNDay") %>입니다.</h2> 
	</div>
</body>
</html>
