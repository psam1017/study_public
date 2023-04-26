<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제발생</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="alert alert-danger">해당 상품이 존재하지 않습니다.</h1>
		</div>
	</div>
	<div class="container">
		<p> <%=request.getRequestURL() %>?<%= request.getQueryString() %>
		<p> <a href="market.jsp" class="btn btn-secondary"> 상품 목록으로 돌아가기 </a>
	</div>
</body>
</html>