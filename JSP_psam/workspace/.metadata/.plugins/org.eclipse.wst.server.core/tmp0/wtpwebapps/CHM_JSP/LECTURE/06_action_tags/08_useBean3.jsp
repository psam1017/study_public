<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 태그</title>
</head>
<body>
	<!-- 스크립틀릿 태그 없이 JSP에서 사용할 수 있도록 변수와 클래스를 선언한다. -->
	<jsp:useBean id="person" class="_06_action_tags.Person" scope="request"/>
	<%
		person.setId(101);
		person.setName("박성민");
	%>
	<!--
		현재 파일과 person.jsp 둘 다 requestScope에서 person을 사용하고 있기 때문에 서로 값을 주고 받을 수 있다.
		하지만, pageScope로는 값을 주고 받을 수 없다. 쿼리스트링도 없고, 페이지를 벗어나면 값이 유지되지 않기 때문에.
	-->
	<jsp:include page="person.jsp"/>
</body>
</html>