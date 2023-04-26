<%@page import="java.util.Enumeration"%>
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
		String name;
		String value;
		
		Enumeration<String> en = session.getAttributeNames();
		int i = 0;
		
		if(session.getAttribute("id") != null){
			while(en.hasMoreElements()){
				i++;
				name = en.nextElement().toString();
				value = session.getAttribute(name).toString();
				out.print("설정된 속성 이름[" + i + "]" + name + "<br>");
				out.print("속성의 값[" + i + "]" + value + "<br><br>");
			}
		}
		else{
				out.print("세션에 아이디가 없습니다.");
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