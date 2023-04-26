<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean class="com.jspex.beans.MemberVO" id="vo"></jsp:useBean> <!-- HTML에서 스크립트 태그에 의존하지 않고, MemberVO를 객체처럼 사용 -->
<jsp:useBean class="com.jspex.beans.MemberDAO" id="dao"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
	<!-- HTML 주석은 컴파일을 막는 게 아니라 출력을 막을 뿐이다. 즉, HTML 주석을 사용하면 실제로는 값이 들어가게 된다. -->
	<%-- JSP 주석은 컴파일도 막을 수 있다.
	<jsp:setProperty property="name" name="vo" value="박성민"/>
	<jsp:setProperty property="birthday" name="vo" value="10-17"/>
	 --%>
	
	<jsp:getProperty property="name" name="vo"/>
	<jsp:getProperty property="birthday" name="vo"/>
</body>
</html>