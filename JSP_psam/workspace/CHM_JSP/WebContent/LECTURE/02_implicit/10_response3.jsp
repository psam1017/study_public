<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects - response</title>
</head>
<body>
	<%
		// 404 에러 페이지에 메시지를 직접 작성할 수 있다.
		response.sendError(404, "죄송합니다. 요청하신 페이지를 찾을 수가 없습니다.");
	%>
</body>
</html>