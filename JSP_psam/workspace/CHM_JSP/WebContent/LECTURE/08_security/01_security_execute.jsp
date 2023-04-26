<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1. Servers - Tomcat v9.0 Server at localhost-config - tomcat-users.xml에서 role을 설정
		2. web.xml에서 경로와 보안 설정(basic 방식)
		3. 1과 2가 제대로 설정이 되었다면 브라우저에서 자동으로 인증을 요청함
	 -->
	<!-- 
		1. Servers - Tomcat v9.0 Server at localhost-config - tomcat-users.xml에서 role을 설정
		2. web.xml에서 경로와 보안 설정(form 방식)
		3. 1과 2가 제대로 설정이 되었다면 로그인 페이지로 보내고, 거기에서 로그인에 성공하면 다시 여기로 되돌아올 수 있다.
		3-1. 로그인에 실패하면 실패 페이지로 이동한다.
		3-2. 로그인 페이지를 직접 실행하면 로그인에 성공했을 때 이동해야 할 페이지 정보가 없기 때문에 오류가 발생한다.
	 -->
	 <p> 로그인 성공
</body>
</html>