<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실행</title>
</head>
<body>
<%! String url = null; %>
<%
if(request.getParameter("id").equals("psam1017") && request.getParameter("pw").equals("qwer1234")){
	url = "21_loginOK.jsp";
}
else{
	url = "02_myErrorPage.jsp";
}
%>
	<jsp:forward page="<%= url %>"/>
</body>
</html>