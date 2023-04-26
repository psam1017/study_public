<%@page import="java.util.Enumeration"%>
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
	<p>
		클라이언트 IP : <%=request.getRemoteAddr()%>            <br>
		요청 정보 길이 : <%=request.getContentLength()%>        <br>
		요청 정보 인코딩 : <%=request.getCharacterEncoding()%>  <br>
		요청 정보 콘텐트 유형 : <%=request.getContentType()%>   <br>
		요청 정보 프로토콜 : <%=request.getProtocol()%>         <br>
		요청 정보 전송방식 : <%=request.getMethod()%>           <br>
		요청 URI : <%=request.getRequestURI()%>                 <br>
		요청 URL : <%=request.getRequestURL()%>                 <br>
		콘텍스트 경로 : <%=request.getContextPath()%>           <br>
		서버 이름 : <%=request.getServerName()%>                <br>
		서버 포트 : <%=request.getServerPort()%>                <br>
		쿼리문 : <%=request.getQueryString()%>                  <br>
	</p>
</body>
</html>
