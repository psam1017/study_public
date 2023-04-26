<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects - request</title>
</head>
<body>
	<%
		// request 등은 _jspService 안에서 생성된 지역변수이기 때문에 선언문 태그에서는 사용할 수 없다.
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	%>
	<p>
		아이디 : <%=id%>
		<br>
		비밀번호 : <%=password%>
	</p>
</body>
</html>
