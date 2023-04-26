<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제 확인</title>
</head>
<body>
	<%
	String cookie_check = request.getHeader("Cookie");
	if(cookie_check == null){
		out.print("<p>쿠키가 삭제되었습니다.</p>");
	} else{
		out.print("<p>쿠키가 삭제되지 않았습니다. 모든 쿠키를 지운 후 다시 시도해보세요.</p>");
	}
	%>
</body>
</html>