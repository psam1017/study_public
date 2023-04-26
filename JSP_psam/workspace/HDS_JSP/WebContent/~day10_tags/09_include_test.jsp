<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브 태그 예제</title>
</head>
<body>
<!-- header -->
<%@ include file="10_header.jsp" %>

<p>----------------------------본문 영역----------------------------</p>

<!-- footer -->
<%@ include file="11_footer.jsp" %>
</body>
</html>