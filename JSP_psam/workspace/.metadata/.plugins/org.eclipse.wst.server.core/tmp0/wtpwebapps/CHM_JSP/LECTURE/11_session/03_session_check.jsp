<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%! int count = 0; %>
	<p>이 페이지는 3초마다 새로고침됩니다.</p>
	<%
		response.setIntHeader("Refresh", 3);
	%>
	<p> 새로고침된 횟수 : <%= count++ %>
	<p> 세션 생성 시간 : <%= session.getCreationTime() %>
	<p> 세션 마지막 접근 시간 : <%= session.getLastAccessedTime() %>
	<br><br>
	<%
		String sessionId = (String)session.getAttribute("id");
		if(sessionId != null){
	%>
		<p> 세션에 저장된 아이디 : <%= sessionId %>
	<%
		}
		else{
	%>
		<p> 세션에 저장된 아이디가 없습니다.
	<%
		}
	%>
	<br><br>
	<a href="01_session_request.jsp">세션 만들러 돌아가기</a>
	<br>
	<a href="04_session_delete.jsp">세션 삭제하기</a>
	<br>
	<a href="04_session_delete2.jsp">세션 삭제하기 ver.2</a>
</body>
</html>