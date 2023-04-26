<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
<%
	out.print("request.isRequestedSessionIdValid()사용<br>");
	
	if(request.isRequestedSessionIdValid()){
		out.print("유효한 세션");
	}
	else{
		out.print("유효하지 않은 세션");
	}
	
	session.invalidate();
%>
<br><h4>-----세션을 삭제한 후-----</h4><br>
<%
	if(request.isRequestedSessionIdValid()){
		out.print("유효한 세션");
	}
	else{
		out.print("유효하지 않은 세션");
	}
%>
	<br><br>
	<a href="01_session_request.jsp">세션 만들러 돌아가기</a>
	<br>
	<a href="03_session_check.jsp">세션 확인하기</a>
	<br>
	<a href="03_session_check2.jsp">세션 확인하기 ver.2</a>
</body>
</html>