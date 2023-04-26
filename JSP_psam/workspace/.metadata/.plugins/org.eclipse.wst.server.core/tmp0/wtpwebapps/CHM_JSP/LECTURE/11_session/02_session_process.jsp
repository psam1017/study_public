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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals(pw)){
		session.setAttribute("id", id); // 세션에 데이터를 저장
		session.setAttribute("pw", pw); // 세션에 데이터를 저장
		session.setMaxInactiveInterval(3); // 3초 동안 세션을 유지
		out.print("세션을 설정했습니다.<br>");
		out.print(id + "님 환영합니다.");
%>
	<p>이 세션은 3초 동안만 유지됩니다.
	<br>
	<a href="03_session_check.jsp">세션 확인하기</a>
	<br>
	<a href="03_session_check2.jsp">세션 확인하기 ver.2</a>
	<br>
	<a href="04_session_delete.jsp">세션 삭제하기</a>
	<br>
	<a href="04_session_delete2.jsp">세션 삭제하기 ver.2</a>
<%
	}
	else{
		out.print("세션을 설정하지 못 했습니다.");
	}
%>
</body>
</html>